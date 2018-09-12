SUMMARY = "C library for multiple-precision floating-point computations with exact rounding"
HOMEPAGE = "http://www.mpfr.org/"
LICENSE = "LGPLv3+"
SECTION = "devel"

inherit autotools texinfo debian-package-ng

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
		    file://COPYING.LESSER;md5=6a6a8e020838b23406c81b19c1d46df6"
DEPENDS = "gmp autoconf-archive"

DPN = "mpfr4"
# override 'S' set by debian-package-ng
S = "${WORKDIR}/${BPN}-${DEB_SRC_VERSION}"
SRC_URI[dsc.md5sum] = "f086860d07172ab5909c0bbaac88f0e7"
SRC_URI[dsc.sha256sum] = "85d8dad92d3f9ace96ac78b2f4ec00eafef228fa53e0344ae4255fc4d3f75626"

UPSTREAM_CHECK_URI = "http://www.mpfr.org/mpfr-current/"

BBCLASSEXTEND = "native nativesdk"
