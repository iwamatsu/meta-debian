SUMMARY = "Real-time file compressor"
DESCRIPTION = "lzop is a compression utility which is designed to be a companion to gzip. \n\
It is based on the LZO data compression library and its main advantages over \n\
gzip are much higher compression and decompression speed at the cost of some \n\
compression ratio. The lzop compression utility was designed with the goals \n\
of reliability, speed, portability and with reasonable drop-in compatibility \n\
to gzip."
DEPENDS += "lzo"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=dfeaf3dc4beef4f5a7bdbc35b197f39e \
                    file://src/lzop.c;beginline=5;endline=21;md5=6797bd3ed0a1a49327b7ebf9366ebd86"

SRC_URI += " \
           file://acinclude.m4 \
           file://x32_abi_miniacc_h.patch \
          "


# debian/static-inlines.patch
# file://0001-use-static-inlines-as-the-external-inline-definition.patch
# debian/static-assert.patch
# file://lzop-1.03-gcc6.patch

inherit debian-package-ng
inherit autotools

SRC_URI[dsc.md5sum] = "8c985dde0f537eec5c6011f203577a2e"
SRC_URI[dsc.sha256sum] = "d2367fbfb2df9e23b931ca96df27cb8835c6dc77c915867b085544d4899f7472"

do_configure_prepend () {
    install -Dm 0644 ${WORKDIR}/acinclude.m4 ${S}/acinclude.m4
}

BBCLASSEXTEND = "native nativesdk"
