SUMMARY = "Keytable files and keyboard utilities"
HOMEPAGE = "http://www.kbd-project.org/"
# everything minus console-fonts is GPLv2+
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=a5fcc36121d93e1f69d96a313078c8b5"

inherit autotools gettext ptest pkgconfig debian-package-ng

SRC_URI[dsc.md5sum] = "958d849f316af8c8f274cbcf1193e911"
SRC_URI[dsc.sha256sum] = "aaf6e2ac6b66cf318cc2108e99d9cc1ad376dbcac40763e9b8756bff0fbb982c"


RREPLACES_${PN} = "console-tools"
RPROVIDES_${PN} = "console-tools"
RCONFLICTS_${PN} = "console-tools"

SRC_URI += " \
           file://run-ptest \
           ${@bb.utils.contains('DISTRO_FEATURES', 'ptest', 'file://set-proper-path-of-resources.patch', '', d)} \
          "

PACKAGECONFIG ?= "${@bb.utils.filter('DISTRO_FEATURES', 'pam', d)} \
                  ${@bb.utils.contains('PTEST_ENABLED', '1', 'tests','', d)} \
                  "

PACKAGECONFIG[pam] = "--enable-vlock, --disable-vlock, libpam,"
PACKAGECONFIG[tests] = "--enable-tests, --disable-tests, libcheck"

do_compile_ptest() {
    oe_runmake -C ${B}/tests dumpkeys-fulltable alt-is-meta
}

do_install_ptest() {
    install -D ${B}/tests/Makefile ${D}${PTEST_PATH}/tests/Makefile
    sed -i -e '/Makefile:/,/^$/d' -e '/%: %.in/,/^$/d' \
	-e 's:--sysroot=${STAGING_DIR_TARGET}::g' \
	-e 's:${DEBUG_PREFIX_MAP}::g' \
	-e 's:${HOSTTOOLS_DIR}/::g' \
	-e 's:${RECIPE_SYSROOT_NATIVE}::g' \
	-e 's:${RECIPE_SYSROOT}::g' \
	-e 's:${S}/config/missing::g' \
	-e 's:${WORKDIR}::g' \
	-e '/libkeymap_.*_SOURCES =/d' -e '/$(EXEEXT):/,/^$/d' ${D}${PTEST_PATH}/tests/Makefile

    find ${B}/tests -executable -exec install {} ${D}${PTEST_PATH}/tests \;
    find ${S}/tests \( -name \*.map -o -name \*.bin -o -name \*.output \) -exec install {} ${D}${PTEST_PATH}/tests \;

    install -D -m 755 ${S}/config/test-driver ${D}${PTEST_PATH}/config/test-driver
}

PACKAGES += "${PN}-consolefonts ${PN}-keymaps ${PN}-unimaps ${PN}-consoletrans"

FILES_${PN}-consolefonts = "${datadir}/consolefonts"
FILES_${PN}-consoletrans = "${datadir}/consoletrans"
FILES_${PN}-keymaps = "${datadir}/keymaps"
FILES_${PN}-unimaps = "${datadir}/unimaps"

RDEPENDS_${PN}-ptest = "make"

inherit update-alternatives

ALTERNATIVE_${PN} = "chvt deallocvt fgconsole openvt showkey"
ALTERNATIVE_PRIORITY = "100"

BBCLASSEXTEND = "native"
