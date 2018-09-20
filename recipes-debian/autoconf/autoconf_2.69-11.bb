require autoconf.inc

LICENSE = "GPLv2 & GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe \
		    file://COPYINGv3;md5=d32239bcb673463ab874e80d47fae504"

inherit debian-package-ng
SRC_URI[dsc.md5sum] = "46e363752814aeffa3c6e773e12ec00a"
SRC_URI[dsc.sha256sum] = "249d25370d4f4d1d0cf7b37bfd178bb6fa87011566dd82230991f64814a39dde"

SRC_URI += "file://check-automake-cross-warning.patch \
	    file://autoreconf-exclude.patch \
	    file://autoreconf-gnuconfigize.patch \
            file://config_site.patch \
            file://remove-usr-local-lib-from-m4.patch \
            file://preferbash.patch \
            file://autotest-automake-result-format.patch \
            file://add_musl_config.patch \
            file://performance.patch \
            file://autoconf-replace-w-option-in-shebangs-with-modern-use-warnings.patch \
           "
SRC_URI_append_class-native = " file://fix_path_xtra.patch"

EXTRA_OECONF += "ac_cv_path_M4=m4 ac_cv_prog_TEST_EMACS=no"

BBCLASSEXTEND = "native nativesdk"
