#
# base recipe: meta/recipes-devtools/perl/perl-rprovides_5.20.0.inc
#	       meta/recipes-devtools/perl/perl-rprovides.inc
# base branch: master
# base commit: a6866222ef6feaa2112618f1442a8960840e394a
#
# Some packages changed names in 5.8.7-r14, RPROVIDE them for things that
# depend on the old name
#
RPROVIDES_perl-module-b-asmdata = "perl-module-${TARGET_SYS}-b-asmdata"
RPROVIDES_perl-module-b-assembler = "perl-module-${TARGET_SYS}-b-assembler"
RPROVIDES_perl-module-b-bblock = "perl-module-${TARGET_SYS}-b-bblock"
RPROVIDES_perl-module-build += "perl-module-module-build"
RPROVIDES_perl-module-b-bytecode = "perl-module-${TARGET_SYS}-b-bytecode"
RPROVIDES_perl-module-b-cc = "perl-module-${TARGET_SYS}-b-cc"
RPROVIDES_perl-module-b-concise = "perl-module-${TARGET_SYS}-b-concise"
RPROVIDES_perl-module-b-debug = "perl-module-${TARGET_SYS}-b-debug"
RPROVIDES_perl-module-b-deparse = "perl-module-${TARGET_SYS}-b-deparse"
RPROVIDES_perl-module-b-disassembler = "perl-module-${TARGET_SYS}-b-disassembler"
RPROVIDES_perl-module-b-lint = "perl-module-${TARGET_SYS}-b-lint"
RPROVIDES_perl-module-b-showlex = "perl-module-${TARGET_SYS}-b-showlex"
RPROVIDES_perl-module-b-stackobj = "perl-module-${TARGET_SYS}-b-stackobj"
RPROVIDES_perl-module-b-stash = "perl-module-${TARGET_SYS}-b-stash"
RPROVIDES_perl-module-b-terse = "perl-module-${TARGET_SYS}-b-terse"
RPROVIDES_perl-module-b-xref = "perl-module-${TARGET_SYS}-b-xref"
RPROVIDES_perl-lib += " \
    perl-module-config \
    perl-module-config-heavy \
    perl-module-${TARGET_SYS}-config \
    perl-module-${TARGET_SYS}-config-heavy"
RPROVIDES_perl-module-encode-alias = "perl-module-${TARGET_SYS}-encode-alias"
RPROVIDES_perl-module-encode-cjkconstants = "perl-module-${TARGET_SYS}-encode-cjkconstants"
RPROVIDES_perl-module-encode-config = "perl-module-${TARGET_SYS}-encode-config"
RPROVIDES_perl-module-encode-encoder = "perl-module-${TARGET_SYS}-encode-encoder"
RPROVIDES_perl-module-encode-encoding = "perl-module-${TARGET_SYS}-encode-encoding"
RPROVIDES_perl-module-encode-guess = "perl-module-${TARGET_SYS}-encode-guess"
RPROVIDES_perl-module-encoding = "perl-module-${TARGET_SYS}-encoding"
RPROVIDES_perl-module-errno = "perl-module-${TARGET_SYS}-errno"
RPROVIDES_perl-module-io-dir = "perl-module-${TARGET_SYS}-io-dir"
RPROVIDES_perl-module-io-file = "perl-module-${TARGET_SYS}-io-file"
RPROVIDES_perl-module-io-handle = "perl-module-${TARGET_SYS}-io-handle"
RPROVIDES_perl-module-io-pipe = "perl-module-${TARGET_SYS}-io-pipe"
RPROVIDES_perl-module-io-poll = "perl-module-${TARGET_SYS}-io-poll"
RPROVIDES_perl-module-io-seekable = "perl-module-${TARGET_SYS}-io-seekable"
RPROVIDES_perl-module-io-select = "perl-module-${TARGET_SYS}-io-select"
RPROVIDES_perl-module-io-socket = "perl-module-${TARGET_SYS}-io-socket"
RPROVIDES_perl-module-ipc-msg = "perl-module-${TARGET_SYS}-ipc-msg"
RPROVIDES_perl-module-ipc-semaphore = "perl-module-${TARGET_SYS}-ipc-semaphore"
RPROVIDES_perl-module-lib = "perl-module-${TARGET_SYS}-lib"
RPROVIDES_perl-module-mime-quotedprint = "perl-module-${TARGET_SYS}-mime-quotedprint"
RPROVIDES_perl-module-o = "perl-module-${TARGET_SYS}-o"
RPROVIDES_perl-module-ops = "perl-module-${TARGET_SYS}-ops"
RPROVIDES_perl-module-safe = "perl-module-${TARGET_SYS}-safe"
RPROVIDES_perl-module-xsloader = "perl-module-${TARGET_SYS}-xsloader"
RPROVIDES_perl-module-module-build += "libmodule-build-perl"
