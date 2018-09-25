SUMMARY = "GNU awk text processing utility"
DESCRIPTION = "The GNU version of awk, a text processing utility. \
Awk interprets a special-purpose programming language to do \
quick and easy text pattern matching and reformatting jobs."
HOMEPAGE = "https://www.gnu.org/software/gawk/"
BUGTRACKER  = "bug-gawk@gnu.org"
SECTION = "console/utils"

# gawk <= 3.1.5: GPLv2
# gawk >= 3.1.6: GPLv3
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += "readline"

PACKAGECONFIG[mpfr] = "--with-mpfr,--without-mpfr, mpfr"

SRC_URI += " \
           file://run-ptest \
           file://remove-doc.patch \
"

inherit autotools gettext update-alternatives debian-package-ng

S = "${WORKDIR}/gawk-4.2.1"
DPV = "1:4.2.1+dfsg-1"
SRC_URI[dsc.md5sum] = "3240e04bf61f28d64dfc74af48ceb3b9"
SRC_URI[dsc.sha256sum] = "5069f96a8589f6215776d79f309b74d8fda0bacb94ee59fea41bb3861d6c1dc6"
EXTRA_OECONF += "--disable-rpath"

# Touch empty gawk.texi file according to debian/rules.
do_configure_prepend() {
	# see debian/rules and comments in remove-doc.patch
	touch --date="Jan 01 2000" \
		${S}/doc/gawktexi.in ${S}/doc/gawk.texi ${S}/doc/gawkinet.texi \
		${S}/doc/gawkworkflow.texi ${S}/doc/gawkworkflow.info \
		${S}/doc/gawk.info ${S}/doc/gawkinet.info ${S}/doc/sidebar.awk
}

do_install_append() {
	# Remove unwanted files.
	rm -f ${D}${bindir}/*awk-*
	# rm -f ${D}${bindir}/awk
	# Remove fake info files
	rm -rf ${D}${datadir}/info
}

FILES_${PN} += "${datadir}/awk"
FILES_${PN}-dev += "${libdir}/${BPN}/*.la"

ALTERNATIVE_${PN} = "awk"
ALTERNATIVE_TARGET[awk] = "${bindir}/gawk"
ALTERNATIVE_PRIORITY = "100"

do_install_append() {
	# remove the link since we don't package it
	rm ${D}${bindir}/awk
}

inherit ptest

do_install_ptest() {
	mkdir ${D}${PTEST_PATH}/test
	for i in `grep -vE "@|^$|#|Gt-dummy" ${S}/test/Maketests |awk -F: '{print $1}'` Maketests inclib.awk; \
	  do cp ${S}/test/$i* ${D}${PTEST_PATH}/test; \
	done
	sed -i -e 's|/usr/local/bin|${bindir}|g' \
	    -e 's|#!${base_bindir}/awk|#!${bindir}/awk|g' ${D}${PTEST_PATH}/test/*.awk
}

BBCLASSEXTEND = "native nativesdk"
