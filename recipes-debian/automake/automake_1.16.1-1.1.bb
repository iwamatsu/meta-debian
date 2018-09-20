require automake.inc
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
DEPENDS_class-native = "autoconf-native"

SRC_URI[dsc.md5sum] = "75e58bc1f9023c5d77d6cb26da6ad103"
SRC_URI[dsc.sha256sum] = "cbde407313f7306389f323ef2ca07e77f9c344b420d3caded3733bced6080014"

inherit debian-package-ng
NAMEVER = "${@oe.utils.trim_version("${PV}", 2)}"

RDEPENDS_${PN} += "\
    autoconf \
    perl \
    perl-module-bytes \
    perl-module-data-dumper \
    perl-module-strict \
    perl-module-text-parsewords \
    perl-module-thread-queue \
    perl-module-threads \
    perl-module-vars "

RDEPENDS_${PN}_class-native = "autoconf-native hostperl-runtime-native"
RDEPENDS_${PN}_class-nativesdk = "nativesdk-autoconf"

SRC_URI += "file://python-libdir.patch \
            file://buildtest.patch \
            file://performance.patch \
            file://new_rt_path_for_test-driver.patch \
            file://automake-replace-w-option-in-shebangs-with-modern-use-warnings.patch \
            file://0001-automake-Add-default-libtool_tag-to-cppasm.patch \
            file://0001-build-fix-race-in-parallel-builds.patch \
            "

DPV = "1:1.16.1-1.1"
DPN = "automake-1.16"
S = "${WORKDIR}/automake-${DEB_SRC_VERSION}"

PERL = "${USRBINPATH}/perl"
PERL_class-native = "${USRBINPATH}/env perl"
PERL_class-nativesdk = "${USRBINPATH}/env perl"

CACHED_CONFIGUREVARS += "ac_cv_path_PERL='${PERL}'"

do_install_append () {
    install -d ${D}${datadir}
}

BBCLASSEXTEND = "native nativesdk"
