LICENSE = "GPLv3 & LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://tests/COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://glob/COPYING.LIB;md5=4a770b67e6be0f60da244beb2de0fce4"
require make.inc
inherit debian-package-ng
DPN = "make-dfsg"

EXTRA_OECONF += "--without-guile"

DEBIAN_PATCH_TYPE = "nopatch"
SRC_URI[dsc.md5sum] = "794c89bf78b2e12c8026ba5dca89aa63"
SRC_URI[dsc.sha256sum] = "0c8a2da5d51e03bf43e2929322d5a8406f08e5ee2d81a71ed6e5a8734f1b05cb"

BBCLASSEXTEND = "native nativesdk"
