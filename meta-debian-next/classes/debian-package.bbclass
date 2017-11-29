S = "${WORKDIR}/${PN}-${PV}"

# TODO
# * downloaded through SRC_URI => how to verify?
# * use a common apt config (e.g. DEBIAN_MIRROR)
fetch_srcpkg() {
	PWD_OLD=${PWD}
	cd ${DL_DIR}
	apt-get source -d ${PN}
	cd ${PWD_OLD}
}
do_fetch_append() {
    bb.build.exec_func("fetch_srcpkg", d)
}

# TODO: remove root privileges
do_build() {
	sudo -E pbuilder build \
		--mirror ${DEBIAN_MIRROR} \
		--distribution ${DISTRO_CODENAME} \
		--host-arch ${DEB_ARCH} \
		${DL_DIR}/${PN}_${PV}.dsc
}
addtask build after do_unpack

# FIXME: DEPENDS doesn't work
do_build[depends] += "pbuilder-native:do_build"

# TODO: no do_clean and do_cleanall
