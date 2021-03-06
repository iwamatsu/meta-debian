SUMMARY = "Minimal boot requirements"
LICENSE = "MIT"

PR = "r0"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# Set by the machine configuration with packages essential for device bootup
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""

# Distro can override the following VIRTUAL-RUNTIME providers:
VIRTUAL-RUNTIME_init_manager ?= "busybox"

#
# minimal package set for root filesystem
#
# ${VIRTUAL-RUNTIME_init_manager}
#   provides init program (busybox or systemd)
# base-files:
#   provides essential data for most system
# base-passwd:
#   provides the default passwd/group data
# update-alternatives:
#   essential for packages that require update-alternatives.bbclass
#
RDEPENDS_${PN} = "${VIRTUAL-RUNTIME_init_manager} \
                  base-files \
                  base-passwd \
                  update-alternatives \
                  ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS} \
                 "
