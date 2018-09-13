inherit debian-package-ng
require readline.inc

SRC_URI[dsc.md5sum] = "aefa3bba83230c609e45e23dc9a63143"
SRC_URI[dsc.sha256sum] = "4a804235e91ced3b957b0772101ca3992f5ad051e6540b8c41a1f98a06e84033"

SRC_URI += "file://configure-fix.patch"

# already in debian
# file://norpath.patch

