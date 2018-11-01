require attr.inc
DPV = "1:2.4.47-2"
PR = "r0"


SRC_URI[dsc.md5sum] = "027d31a50edfd80e210d496a8d28b401"
SRC_URI[dsc.sha256sum] = "ee842d6d62d473acf02b494c432cf33128fa46455a09d3172c77c252449fa1a6"

# configure.ac was missing from the release tarball. This should be fixed in
# future releases of attr, remove this when updating the recipe.
SRC_URI += "file://attr-Missing-configure.ac.patch \
            file://dont-use-decl-macros.patch \
            file://Remove-the-section-2-man-pages.patch \
            file://Remove-the-attr.5-man-page-moved-to-man-pages.patch \
            file://0001-Use-stdint-types-consistently.patch \
           "

BBCLASSEXTEND = "native nativesdk"
