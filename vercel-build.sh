#!/bin/bash
# Download OpenJDK 17
echo "Downloading OpenJDK 17..."
curl -L https://github.com/adoptium/temurin17-binaries/releases/download/jdk-17.0.9%2B9/OpenJDK17U-jdk_x64_linux_hotspot_17.0.9_9.tar.gz -o jdk17.tar.gz

# Extract
tar -xzf jdk17.tar.gz

# Set Environment Variables
export JAVA_HOME=$(pwd)/jdk-17.0.9+9
export PATH=$JAVA_HOME/bin:$PATH

# Verify Java Version
java -version

# Run Build
./gradlew wasmJsBrowserDistribution
