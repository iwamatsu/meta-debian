require shadow.inc

SRC_URI[dsc.md5sum] = "68b5c055b71cb6c26c6a7dd5b02d5c6a"
SRC_URI[dsc.sha256sum] = "75993dc19ccc4d5c404831d2dab021a03eaa39216b518d596b639d8f2ea4e98b"

# Build falsely assumes that if --enable-libpam is set, we don't need to link against
# libcrypt. This breaks chsh.
BUILD_LDFLAGS_append_class-target = " ${@bb.utils.contains('DISTRO_FEATURES', 'pam', bb.utils.contains('DISTRO_FEATURES', 'libc-crypt',  '-lcrypt', '', d), '', d)}"

BBCLASSEXTEND = "native nativesdk"


SRC_URI += "file://man.patch"
