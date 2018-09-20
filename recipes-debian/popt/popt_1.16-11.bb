SUMMARY = "Library for parsing command line options"
HOMEPAGE = "http://rpm5.org/"
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=cb0613c30af2a8249b8dcc67d3edb06d"
PR = "r0"

DEPENDS = "virtual/libiconv"

SRC_URI += " \
           file://disable_tests-for-debian.patch \
          "
# same as popt-1.16-pkgconfig.patch
# file://pkgconfig_fix.patch 
# same as 757935-autoreconf-remove-am-c-prototypes.patch
# file://popt_fix_for_automake-1.12.patch

SRC_URI[dsc.md5sum] = "bc1f4856cd95dcd872e4bbf66b098d14"
SRC_URI[dsc.sha256sum] = "c24642164b4ff9ad66ac985f02008c181b587d7b05dae5cdd208662d17752013"

#SRC_URI[md5sum] = "3743beefa3dd6247a73f8f7a32c14c33"
#SRC_URI[sha256sum] = "e728ed296fe9f069a0e005003c3d6b2dde3d9cad453422a10d6558616d304cc8"

inherit autotools gettext debian-package-ng

BBCLASSEXTEND = "native nativesdk"
