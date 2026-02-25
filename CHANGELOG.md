# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Security

- Fixed critical bug in QuickSort random pivot selection. The operator precedence error caused the pivot to always be the first element, breaking the algorithm's O(n log n) average case guarantee. ([GHSA-#], CWE-697)
- Removed all npm dependencies, eliminating 9 security vulnerabilities:
  - ansi-regex (High) - ReDoS vulnerability
  - braces (High) - Uncontrolled resource consumption
  - cross-spawn (High) - ReDoS vulnerability
  - minimatch (High) - ReDoS vulnerability
  - lodash (Moderate) - Prototype pollution
  - micromatch (Moderate) - ReDoS vulnerability
  - brace-expansion (Low) - ReDoS vulnerability
  - java-parser, prettier-plugin-java (transitive vulnerabilities)

### Changed

- **Breaking**: Removed npm as a build dependency. Project now uses pure Maven toolchain.
- Replaced Prettier (npm) with Spotless Maven plugin for code formatting
- Replaced Husky (npm) with native git hooks
- Updated JUnit Jupiter from 5.7.1 to 5.10.2
- Updated Lombok from 1.18.20 to 1.18.30
- Updated all Maven plugins to latest versions

### Added

- Spotless Maven plugin for code formatting (Google Java Format, AOSP style)
- Checkstyle Maven plugin for code style enforcement (Google checks)
- SpotBugs Maven plugin for static analysis and bug detection
- Git hooks setup script (`scripts/setup-git-hooks.sh`)
- Pre-commit hook to prevent direct commits to master/main and enforce code formatting
- CHANGELOG.md to track project changes

### Removed

- `package.json` - npm configuration (no longer needed)
- `package-lock.json` - npm lock file
- `.prettierrc` - Prettier configuration (replaced by Spotless)
- `node_modules/` - npm dependencies directory
- npm devDependencies: prettier, prettier-plugin-java, prettier-plugin-package, prettier-plugin-packagejson, husky, lint-staged, git-branch-is

### Fixed

- QuickSort pivot selection bug - random pivot now correctly selected instead of always choosing the first element

## [1.1.0] - Previous Release

### Added

- Sorting Algorithms solutions
- Binary Search solutions
- Recursion solutions
- Queue & Stack solutions
- Linked List solutions
- Binary Tree solutions
- Documentation for implemented algorithms