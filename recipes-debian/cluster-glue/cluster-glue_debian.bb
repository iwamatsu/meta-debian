PR = "r0"

inherit debian-package

LICENSE = "GPLv2 | LGPLv2.1 | BSD | PD"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "libxml2 libtool glib-2.0 bzip2 util-linux libxslt"

inherit autotools pkgconfig

SRC_URI_append = " \
    file://0001-don-t-compile-doc-and-Error-Fix.patch \
"

EXTRA_OECONF += "--disable-fatal-warnings --enable-doc=no \
	--with-initdir=${sysconfdir}/init.d"

do_configure_prepend() {
        cd ${S}
        ./autogen.sh && cd -
}

PACKAGES =+ "liblrm2 liblrm2-dev libplumb2 libplumb2-dev libpils2 \
	libpils2-dev libplumbgpl2 libstonith1 libstonith1-dev"

FILES_${PN} += " \
	${libdir}/stonith/plugins/xen0-ha-dom0-stonith-helper \
	${libdir}/stonith/plugins/external \
	${libdir}/stonith/plugins/stonith2/ribcl.py \
	${libdir}/stonith/plugins/stonith2/*.so \
	${libdir}/stonith/plugins/external/* \
	${libdir}/heartbeat/logtest \
	${libdir}/heartbeat/ha_logd \
	${libdir}/heartbeat/ipctest \
	${libdir}/heartbeat/base64_md5_test \
	${libdir}/heartbeat/transient-test.sh \
	${libdir}/heartbeat/lrmd \
	${libdir}/heartbeat/ipctransientclient \
	${libdir}/heartbeat/ipctransientserver \
	${libdir}/heartbeat/plugins/RAExec/*.so \
	${libdir}/heartbeat/plugins/test/*.so \
	${libdir}/heartbeat/plugins/compress/*.so \
	${libdir}/heartbeat/plugins/InterfaceMgr/*.so \
	"

FILES_${PN}-dbg += " \
	${libdir}/stonith/plugins/stonith2/.debug/* \
	${libdir}/heartbeat/.debug/* \
	${libdir}/heartbeat/plugins/RAExec/.debug/* \
	${libdir}/heartbeat/plugins/test/.debug/* \
	${libdir}/heartbeat/plugins/compress/.debug/* \
	${libdir}/heartbeat/plugins/InterfaceMgr/.debug/* \
	"
	
FILES_${PN}-dev += " \
	${libdir}/stonith/plugins/stonith2/*.la \
	${libdir}/heartbeat/plugins/RAExec/*.la \
	${libdir}/heartbeat/plugins/test/*.la \
	${libdir}/heartbeat/plugins/compress/*.la \
	${libdir}/heartbeat/plugins/InterfaceMgr/*.la \
	"

FILES_${PN}-staticdev += " \
	${libdir}/heartbeat/plugins/InterfaceMgr/*.a \
	${libdir}/heartbeat/plugins/compress/*.a \
	${libdir}/heartbeat/plugins/test/*.a \
	${libdir}/heartbeat/plugins/RAExec/*.a \
	${libdir}/stonith/plugins/stonith2/*.a \
	"
FILES_liblrm2 = " \
	${libdir}/liblrm.so.2 \
	${libdir}/liblrm.so.2.0.0 \
	"

FILES_liblrm2-dev = "${includedir}/heartbeat/lrm"

FILES_libplumb2 = " \
	${libdir}/libplumb.so.2 \
	${libdir}/libplumb.so.2.1.0 \
	"

FILES_libplumb2-dev = "${includedir}/clplumbing"

FILES_libpils2 = " \
	${libdir}/libpils.so.2 \
	${libdir}/libpils.so.2.0.0 \
	"

FILES_libpils2-dev = "${includedir}/pils"

FILES_libplumbgpl2 = " \
	${libdir}/libplumbgpl.so.2 \
	${libdir}/libplumbgpl.so.2.0.0 \
	"

FILES_libstonith1 = " \
	${libdir}/libstonith.so.1 \
	${libdir}/libstonith.so.1.0.0 \
	"

FILES_libstonith1-dev = "${includedir}/stonith"
