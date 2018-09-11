SUMMARY = "Traditional Unix macro processor"
HOMEPAGE = "https://www.gnu.org/software/m4/m4.html"
DESCRIPTION = "GNU m4 is an implementation of the traditional Unix macro processor.  It is mostly SVR4 \
compatible although it has some extensions (for example, handling more than 9 positional parameters to macros). \
GNU M4 also has built-in functions for including files, running shell commands, doing arithmetic, etc."

inherit autotools texinfo debian-package-ng

SRC_URI[dsc.md5sum] = "c95bf5d0b16110b842a8cb46a9caf407"
SRC_URI[dsc.sha256sum] = "83a6c5e4b94aa47634b7c988fa485155c01120c17682865e6f032de9adf1090c"

SRC_URI += " \
           file://ac_config_links.patch \
           file://remove-gets.patch \
           file://m4-1.4.18-glibc-change-work-around.patch \
           "

SRC_URI_append_class-target = " file://0001-Unset-need_charset_alias-when-building-for-musl.patch"

LICENSE = "GPLv3"

LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504\
	            file://examples/COPYING;md5=4031593b2166d6c47cae282d944a7ede"

# Fix "Argument list too long" error when len(TMPDIR) = 410
acpaths = "-I ./m4"

EXTRA_OECONF += "--without-libsigsegv-prefix"

EXTRA_OEMAKE += "'infodir=${infodir}'"
