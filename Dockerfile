FROM node:20-bullseye-slim

# Instalamos Java manualmente porque esta imagen solo trae Node
RUN apt-get update && apt-get install -y openjdk-17-jdk

# Instalamos Claude
RUN npm install -g @anthropic-ai/claude-code

WORKDIR /workspace