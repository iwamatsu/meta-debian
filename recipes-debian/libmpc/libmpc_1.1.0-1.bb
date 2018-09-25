require libmpc.inc

DEPENDS = "gmp mpfr"

LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"

inherit debian-package-ng
DPN = "mpclib3"

SRC_URI[dsc.md5sum] = "8bf3b7e7f29bb91839db8edf7c399f45"
SRC_URI[dsc.sha256sum] = "bb57824015b735bf72399a53f8c6a241e6a8bd402753b0fdcdaa5b99d0aef790"

S = "${WORKDIR}/mpc-${DEB_SRC_VERSION}"

UPSTREAM_CHECK_URI = "http://www.multiprecision.org/index.php?prog=mpc&page=download"

BBCLASSEXTEND = "native nativesdk"

