SUMMARY = "Checksumming Copy on Write Filesystem utilities"
DESCRIPTION = "Btrfs is a new copy on write filesystem for Linux aimed at \
implementing advanced features while focusing on fault tolerance, repair and \
easy administration. \
This package contains utilities (mkfs, fsck, btrfsctl) used to work with \
btrfs and an utility (btrfs-convert) to make a btrfs filesystem from an ext3."

HOMEPAGE = "https://btrfs.wiki.kernel.org"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fcb02dc552a041dee27e4b85c7396067"
SECTION = "base"
DEPENDS = "util-linux attr e2fsprogs lzo acl python3-setuptools-native"
DEPENDS_append_class-target = " udev"
RDEPENDS_${PN} = "libgcc"

#SRCREV = "7faaca0d9f78f7162ae603231f693dd8e1af2a41"
SRC_URI += " \
           file://python3-use-deb-layout.patch \
           file://0001-Makefile-build-mktables-using-native-gcc.patch \
           file://0001-Add-LDFLAGS-when-building-libbtrfsutil.so.patch \
           file://0001-Add-a-possibility-to-specify-where-python-modules-ar.patch \
           "

inherit autotools-brokensep pkgconfig manpages distutils3-base debian-package-ng

DPN = "btrfs-progs"
# override 'S' set by debian-package-ng
S = "${WORKDIR}/${DPN}-v${DEB_SRC_VERSION}"
SRC_URI[dsc.md5sum] = "699fd89992632958fb347471adce5db2"
SRC_URI[dsc.sha256sum] = "cf09f9124eb58bda14e4a943a84b4c58e0c0e834f8618245a2bfb4d0f7e80276"

CLEANBROKEN = "1"

PACKAGECONFIG[manpages] = "--enable-documentation, --disable-documentation, asciidoc-native xmlto-native"
EXTRA_OECONF = " --disable-zstd"
EXTRA_OECONF_append_libc-musl = " --disable-backtrace "

do_configure_prepend() {
	# Upstream doesn't ship this and autoreconf won't install it as automake isn't used.
	mkdir -p ${S}/config
	cp -f $(automake --print-libdir)/install-sh ${S}/config/
}

# S = "${WORKDIR}/git"

do_install_append() {
    oe_runmake 'DESTDIR=${D}' 'PYTHON_SITEPACKAGES_DIR=${PYTHON_SITEPACKAGES_DIR}' install_python
}

BBCLASSEXTEND = "native"
