MAJOR_VERSION = "2.32.1"

inherit debian-package-ng
require util-linux.inc

SRC_URI[dsc.md5sum] = "3ac8c2c332d89a3cb311caddb7fd8b10"
SRC_URI[dsc.sha256sum] = "a8a5e6b6e299ccdf262bc8966e8f7bc943194900aef5495b038d987458bd27d4"

# To support older hosts, we need to patch and/or revert
# some upstream changes.  Only do this for native packages.
OLDHOST = ""
OLDHOST_class-native = "file://util-linux-native-qsort.patch"

SRC_URI += "file://configure-sbindir.patch \
            file://runuser.pamd \
            file://runuser-l.pamd \
            ${OLDHOST} \
            file://ptest.patch \
            file://run-ptest \
            file://display_testname_for_subtest.patch \
"

CACHED_CONFIGUREVARS += "scanf_cv_alloc_modifier=ms"

EXTRA_OECONF_class-native = "${SHARED_EXTRA_OECONF} \
                             --disable-fallocate \
			     --disable-use-tty-group \
"
EXTRA_OECONF_class-nativesdk = "${SHARED_EXTRA_OECONF} \
                                --disable-fallocate \
				--disable-use-tty-group \
"
