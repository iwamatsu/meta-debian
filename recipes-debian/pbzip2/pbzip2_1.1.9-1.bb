SUMMARY = "PBZIP2 is a parallel implementation of bzip2"
DESCRIPTION = "PBZIP2 is a parallel implementation of the bzip2 block-sorting \
file compressor that uses pthreads and achieves near-linear speedup on SMP \
machines. The output of this version is fully compatible with bzip2 v1.0.2 or \
newer (ie: anything compressed with pbzip2 can be decompressed with bzip2)."
HOMEPAGE = "http://compression.ca/pbzip2/"
SECTION = "console/utils"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=a0103c113a3613a95e551b86ad99d63d"

DEPENDS = "bzip2"
DEPENDS_append_class-native = " bzip2-replacement-native"

SRC_URI[dsc.md5sum] = "2fc0636fc3693552fec9312dca980352"
SRC_URI[dsc.sha256sum] = "7e0702d47024c3ff521160a5d1708917b5c2e10ed1e57cedcee684058d37a9ca"

inherit debian-package-ng

UPSTREAM_CHECK_URI = "https://launchpad.net/pbzip2/+milestones"
UPSTREAM_CHECK_REGEX = "pbzip2 (?P<pver>\d+(\.\d+)+)"

EXTRA_OEMAKE = "CXX='${CXX} ${CXXFLAGS}' LDFLAGS='${LDFLAGS}'"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 pbzip2 ${D}${bindir}/
}

BBCLASSEXTEND = "native"
