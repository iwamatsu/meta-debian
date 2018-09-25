SUMMARY = "Tools for working with sysfs"
DESCRIPTION = "Tools for working with the sysfs virtual filesystem.  The tool 'systool' can query devices by bus, class and topology."
HOMEPAGE = "http://linux-diag.sourceforge.net/Sysfsutils.html"

LICENSE = "GPLv2 & LGPLv2.1"
LICENSE_${PN} = "GPLv2"
LICENSE_libsysfs = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=3d06403ea54c7574a9e581c6478cc393 \
                    file://cmd/GPL;md5=d41d4e2e1e108554e0388ea4aecd8d27 \
                    file://lib/LGPL;md5=b75d069791103ffe1c0d6435deeff72e"
PR = "r0"

SRC_URI += " \
           file://sysfsutils-2.0.0-class-dup.patch \
           file://obsolete_automake_macros.patch \
           file://separatebuild.patch"

UPSTREAM_CHECK_URI = "http://sourceforge.net/projects/linux-diag/files/sysfsutils/"
UPSTREAM_CHECK_REGEX = "/sysfsutils/(?P<pver>(\d+[\.\-_]*)+)/"


inherit autotools debian-package-ng
S = "${WORKDIR}/sysfsutils-2.1.0"
SRC_URI[dsc.md5sum] = "ba8453acabe245284cbb1275130bd902"
SRC_URI[dsc.sha256sum] = "10e77de23da20bd2eaceddef1ee06e10302f4907e6b5d1894ffa5de0f1e79de3"

PACKAGES =+ "libsysfs"
FILES_libsysfs = "${libdir}/lib*${SOLIBS}"
FILES_libsysfs-dev = "${libdir}/lib*${SOLIBSDEV} ${includedir}"
FILES_libsysfs-staticdev = "${libdir}/lib*.a"

export libdir = "${base_libdir}"
