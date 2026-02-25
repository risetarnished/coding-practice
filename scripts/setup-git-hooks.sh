#!/bin/bash
# Setup script for git hooks
# Run this script after cloning the repository

echo "Setting up git hooks..."

# Create .git/hooks directory if it doesn't exist
mkdir -p .git/hooks

# Copy the pre-commit hook
cp scripts/hooks/pre-commit .git/hooks/pre-commit

# Make it executable
chmod +x .git/hooks/pre-commit

echo "✓ Git hooks installed successfully!"
echo "  - pre-commit: Checks branch name and code formatting"