require libmpc.inc

DEPENDS = "gmp mpfr"

LIC_FILES_CHKSUM = "file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02"
#SRC_URI = "https://ftp.gnu.org/gnu/mpc/mpc-${PV}.tar.gz"

inherit debian-package-ng
DPN = "mpclib3"

SRC_URI[dsc.md5sum] = "8bf3b7e7f29bb91839db8edf7c399f45"
SRC_URI[dsc.sha256sum] = "bb57824015b735bf72399a53f8c6a241e6a8bd402753b0fdcdaa5b99d0aef790"

DEBIAN_ORIG_SRCDIR = "mpc-1.1.0"
#USE_DO_DEBIAN_PATCH = "1"
#SRC_URI[md5sum] = "d6a1d5f8ddea3abd2cc3e98f58352d26"
#SRC_URI[sha256sum] = "617decc6ea09889fb08ede330917a00b16809b8db88c29c31bfbb49cbf88ecc3"

UPSTREAM_CHECK_URI = "http://www.multiprecision.org/index.php?prog=mpc&page=download"

#S = "${WORKDIR}/mpc-${PV}"
BBCLASSEXTEND = "native nativesdk"

