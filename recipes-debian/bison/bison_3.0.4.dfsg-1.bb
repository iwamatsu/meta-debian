SUMMARY = "GNU Project parser generator (yacc replacement)"
DESCRIPTION = "Bison is a general-purpose parser generator that converts an annotated context-free grammar into \
an LALR(1) or GLR parser for that grammar.  Bison is upward compatible with Yacc: all properly-written Yacc \
grammars ought to work with Bison with no change. Anyone familiar with Yacc should be able to use Bison with \
little trouble."
HOMEPAGE = "http://www.gnu.org/software/bison/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
SECTION = "devel"
DEPENDS = "bison-native flex-native"

SRC_URI[dsc.md5sum] = "eed71f7e2ddc81f942697bc430b939a2"
SRC_URI[dsc.sha256sum] = "3878b88305c20178dc0110e458a3885730555f46d7718fe778dde2c47e8a2e50"

inherit debian-package-ng
DPV = "2:3.0.4.dfsg-1"

SRC_URI += " \
           file://m4.patch \
           file://0001-Unset-need_charset_alias-when-building-for-musl.patch \
           file://dont-depend-on-help2man.patch.patch \
           file://0001-src-local.mk-fix-parallel-issue.patch \
           file://add-with-bisonlocaledir.patch \
"

SRC_URI += "file://remove-document-examples-target.patch"

# No point in hardcoding path to m4, just use PATH
EXTRA_OECONF += "M4=m4"

DEPENDS_class-native = "gettext-minimal-native"

inherit autotools gettext texinfo
acpaths = "-I ${S}/m4"

do_compile_prepend() {
	for i in mfcalc calc++ rpcalc; do mkdir -p ${B}/examples/$i; done
}

do_install_append_class-native() {
	create_wrapper ${D}/${bindir}/bison \
		BISON_PKGDATADIR=${STAGING_DATADIR_NATIVE}/bison
}
BBCLASSEXTEND = "native nativesdk"
