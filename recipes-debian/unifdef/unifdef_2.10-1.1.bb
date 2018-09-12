SUMMARY = "Selectively remove #ifdef statements from sources"
SECTION = "devel"
LICENSE = "BSD-2-Clause"
HOMEPAGE = "http://dotat.at/prog/unifdef/"

LIC_FILES_CHKSUM = "file://COPYING;md5=4da83e7128fb3e762bd4678e7e2f358d\
                    file://unifdef.c;endline=32;md5=2cc23f0382a6f560f6a9ecf4e040c0da"

inherit debian-package-ng

SRC_URI[dsc.md5sum] = "09957432c20fc52cbf380b7d6d3f6e14"
SRC_URI[dsc.sha256sum] = "4c1069d5340936631204d3080519d2bb0e9461f4f383baf9ccadf3450f5a9144"

do_install() {
	oe_runmake install DESTDIR=${D} prefix=${prefix}
}

BBCLASSEXTEND = "native"
