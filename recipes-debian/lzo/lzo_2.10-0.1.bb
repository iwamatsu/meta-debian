SUMMARY = "Lossless data compression library"
HOMEPAGE = "http://www.oberhumer.com/opensource/lzo/"
SECTION = "libs"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://src/lzo_init.c;beginline=5;endline=25;md5=9ae697ca01829b0a383c5d2d163e0108"

SRC_URI += " \
           file://0001-Use-memcpy-instead-of-reinventing-it.patch \
	   file://0001-Add-pkgconfigdir-to-solve-the-undefine-error.patch \
           file://run-ptest \
           "

inherit autotools ptest

DPN = "lzo2"
SRC_URI[dsc.md5sum] = "34a529627a1f1165334431f96ef66a24"
SRC_URI[dsc.sha256sum] = "49cdf2efab29d7dd8a907730a37c2c5ca312d9c2150f8e37663838b122856aff"

inherit debian-package-ng
# override 'S' set by debian-package-ng
S = "${WORKDIR}/${BPN}-${DEB_SRC_VERSION}"

EXTRA_OECONF = "--enable-shared"

do_install_ptest() {
	t=${D}${PTEST_PATH}
	cp ${S}/util/check.sh $t
	cp ${B}/minilzo/testmini $t
	for i in tests/align tests/chksum lzotest/lzotest examples/simple
		do cp ${B}/`dirname $i`/.libs/`basename $i` $t; \
	done
}


BBCLASSEXTEND = "native nativesdk"
