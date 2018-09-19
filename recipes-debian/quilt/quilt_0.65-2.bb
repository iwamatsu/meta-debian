require quilt.inc
inherit gettext debian-package-ng

SRC_URI += "file://gnu_patch_test_fix_target.patch"

EXTRA_AUTORECONF += "--exclude=aclocal"

RDEPENDS_${PN} += "patch diffstat bzip2 util-linux"
