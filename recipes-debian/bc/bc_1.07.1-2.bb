SUMMARY = "Arbitrary precision calculator language"
HOMEPAGE = "http://www.gnu.org/software/bc/bc.html"

LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://COPYING.LIB;md5=6a6a8e020838b23406c81b19c1d46df6 \
                    file://bc/bcdefs.h;endline=17;md5=4295c06df9e833519a342f7b5d43db06 \
                    file://dc/dc.h;endline=18;md5=36b8c600b63ee8c3aeade2764f6b2a4b \
                    file://lib/number.c;endline=20;md5=cf43068cc88f837731dc53240456cfaf"

SECTION = "base"
DEPENDS = "flex-native"

SRC_URI[dsc.md5sum] = "fc30a4f7d7314cb67599e9917bb31c52"
SRC_URI[dsc.sha256sum] = "d8d875ff42c9dc5b8c22ff0c7f52fd11a3c994091206bac918a22a2bdc9c2b9b"

inherit debian-package-ng

SRC_URI += " \
           file://no-gen-libmath.patch \
           file://libmath.h"

inherit autotools texinfo update-alternatives

do_compile_prepend() {
    cp -f ${WORKDIR}/libmath.h ${B}/bc/libmath.h
}

ALTERNATIVE_${PN} = "dc"
ALTERNATIVE_PRIORITY = "100"

BBCLASSEXTEND = "native"
