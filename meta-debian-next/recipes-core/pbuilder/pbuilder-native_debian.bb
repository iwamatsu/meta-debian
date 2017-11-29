# assumes that pbuilder package is installed in native environment

do_fetch() {
	:
}

do_unpack() {
	:
}

# TODO: remove root privileges
do_build() {
	sudo -E pbuilder create \
		--mirror ${DEBIAN_MIRROR} \
		--distribution ${DISTRO_CODENAME}
}
addtask build after do_unpack
