SUMMARY = "System and process monitoring utilities"
DESCRIPTION = "Procps contains a set of system utilities that provide system information about processes using \
the /proc filesystem. The package includes the programs ps, top, vmstat, w, kill, and skill."
HOMEPAGE = "https://gitlab.com/procps-ng/procps"
SECTION = "base"
LICENSE = "GPLv2+ & LGPLv2+"
LIC_FILES_CHKSUM="file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                  file://COPYING.LIB;md5=4cf66a4984120007c9881cc871cf49db \
                 "

DEPENDS = "ncurses"


inherit autotools gettext pkgconfig update-alternatives debian-package-ng

DPV = "2:3.3.15-2"
SRC_URI[dsc.md5sum] = "f73b698ef3e19479f0b8530cfa301a7d"
SRC_URI[dsc.sha256sum] = "c7f695ddba2fdf0c3b9de5c38de22713a7046dd9e4a141d59155f4dd62008b32"

SRC_URI += " \
           file://sysctl.conf \
           file://0001-Fix-out-of-tree-builds.patch \
           "

EXTRA_OECONF = "--enable-skill --disable-modern-top"

do_install_append () {
	install -d ${D}${base_bindir}
	[ "${bindir}" != "${base_bindir}" ] && for i in ${base_bindir_progs}; do mv ${D}${bindir}/$i ${D}${base_bindir}/$i; done
	install -d ${D}${base_sbindir}
	[ "${sbindir}" != "${base_sbindir}" ] && for i in ${base_sbindir_progs}; do mv ${D}${sbindir}/$i ${D}${base_sbindir}/$i; done
        if [ "${base_sbindir}" != "${sbindir}" ]; then
                rmdir ${D}${sbindir}
        fi

        install -d ${D}${sysconfdir}
        install -m 0644 ${WORKDIR}/sysctl.conf ${D}${sysconfdir}/sysctl.conf
        if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
                install -d ${D}${sysconfdir}/sysctl.d
                ln -sf ../sysctl.conf ${D}${sysconfdir}/sysctl.d/99-sysctl.conf
        fi
}

CONFFILES_${PN} = "${sysconfdir}/sysctl.conf"

bindir_progs = "free pkill pmap pgrep pwdx skill snice top uptime w"
base_bindir_progs += "kill pidof ps watch"
base_sbindir_progs += "sysctl"

ALTERNATIVE_PRIORITY = "200"
ALTERNATIVE_PRIORITY[pidof] = "150"

ALTERNATIVE_${PN} = "${bindir_progs} ${base_bindir_progs} ${base_sbindir_progs}"

ALTERNATIVE_${PN}-doc = "kill.1 uptime.1"
ALTERNATIVE_LINK_NAME[kill.1] = "${mandir}/man1/kill.1"
ALTERNATIVE_LINK_NAME[uptime.1] = "${mandir}/man1/uptime.1"

python __anonymous() {
    for prog in d.getVar('base_bindir_progs').split():
        d.setVarFlag('ALTERNATIVE_LINK_NAME', prog, '%s/%s' % (d.getVar('base_bindir'), prog))

    for prog in d.getVar('base_sbindir_progs').split():
        d.setVarFlag('ALTERNATIVE_LINK_NAME', prog, '%s/%s' % (d.getVar('base_sbindir'), prog))
}

