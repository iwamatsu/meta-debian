require quilt.inc
require quilt-native.inc
inherit debian-package-ng

SRC_URI[dsc.md5sum] = "05c18c727f2d35c46632d95e98a2bec1"
SRC_URI[dsc.sha256sum] = "70ab6446faadfc83e42fbc4939237f9655d625360b73824cf5f5ab7988573a5a"

# quilt-native also depends on native quilt command.
# This is a special overwritten to apply all patches in
# the quilt source without native quilt command.
debian_patch_quilt() {
	bbnote "applying all patches without quilt command"

	PATCH_DIR=${S}/debian/patches
	if [ ! -s ${PATCH_DIR}/series ]; then
		bbfatal "no patch in series"
	fi
	for patch in $(sed "s@#.*@@" ${PATCH_DIR}/series); do
		bbnote "applying $patch"
		patch -p1 < ${PATCH_DIR}/${patch}
	done
}

