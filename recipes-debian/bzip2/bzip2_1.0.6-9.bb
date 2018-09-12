SUMMARY = "Very high-quality data compression program"
DESCRIPTION = "bzip2 compresses files using the Burrows-Wheeler block-sorting text compression algorithm, and \
Huffman coding. Compression is generally considerably better than that achieved by more conventional \
LZ77/LZ78-based compressors, and approaches the performance of the PPM family of statistical compressors."
HOMEPAGE = "https://sourceware.org/bzip2/"
SECTION = "console/utils"
LICENSE = "bzip2"
LIC_FILES_CHKSUM = "file://LICENSE;beginline=8;endline=37;md5=40d9d1eb05736d1bfc86cfdd9106e6b2"

SRC_URI += "\
           file://configure.ac;subdir=${DPN}-${DEB_SRC_VERSION} \
           file://Makefile.am;subdir=${DPN}-${DEB_SRC_VERSION} \
           file://run-ptest \
           "

SRC_URI[dsc.md5sum] = "95bb8342e0d76b7dc702b93372435330"
SRC_URI[dsc.sha256sum] = "f27d7febca8dbc1519bdacac3ee0b5a2d9cf9845e50dbb7b13c0e6daa17ab28e"

UPSTREAM_CHECK_URI = "https://www.sourceware.org/bzip2/"
UPSTREAM_VERSION_UNKNOWN = "1"

PACKAGES =+ "libbz2"

CFLAGS_append = " -fPIC -fpic -Winline -fno-strength-reduce -D_FILE_OFFSET_BITS=64"

inherit autotools update-alternatives ptest relative_symlinks debian-package-ng

ALTERNATIVE_PRIORITY = "100"
ALTERNATIVE_${PN} = "bunzip2 bzcat"

#install binaries to bzip2-native under sysroot for replacement-native
EXTRA_OECONF_append_class-native = " --bindir=${STAGING_BINDIR_NATIVE}/${PN}"

do_install_ptest () {
	sed -i -e "s|^Makefile:|_Makefile:|" ${D}${PTEST_PATH}/Makefile
}

FILES_libbz2 = "${libdir}/lib*${SOLIBS}"

PROVIDES_append_class-native = " bzip2-replacement-native"
BBCLASSEXTEND = "native nativesdk"

