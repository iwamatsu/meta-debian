inherit debian-package-ng

require ncurses.inc

SRC_URI[dsc.md5sum] = "eb98e51968af97e59b9be44022ff5bc8"
SRC_URI[dsc.sha256sum] = "d4ee01fcada6e29bba632598e517fff5c48329c4191712f07311e3a21d36d4b9"

# override "S' set by debian-package-ng
S = "${WORKDIR}/${BPN}-6.1-20180714"

SRC_URI += "file://0001-tic-hang.patch \
            file://0002-configure-reproducible.patch \
            file://config.cache \
"
# commit id corresponds to the revision in package version
EXTRA_OECONF += "--with-abi-version=5"
UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>\d+(\.\d+)+(\+\d+)*)"
