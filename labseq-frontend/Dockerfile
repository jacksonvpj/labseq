# Etapa 1: Build da aplicação Angular
FROM node:18-alpine AS build

WORKDIR /app

# Copiar package.json e package-lock.json para instalar dependências
COPY ./labseq-frontend/package*.json ./

# Instalar dependências
RUN npm install

# Copiar todo o código-fonte para o diretório de trabalho
COPY ./labseq-frontend .

# Build da aplicação Angular
RUN npm run build --prod

# Etapa 2: Configuração do Nginx para servir a aplicação Angular
FROM nginx:1.27.0-alpine-slim

# Remover configuração padrão do Nginx
RUN rm -rf /usr/share/nginx/html/*

# Copiar os arquivos buildados do estágio anterior para o diretório de conteúdo estático do Nginx
COPY --from=build /app/dist/labseq-frontend/browser /usr/share/nginx/html

# Copiar arquivo de configuração do Nginx
#COPY ./labseq-frontend/configs/nginx.conf /etc/nginx/nginx.conf

# Expor a porta 80 para o tráfego HTTP
EXPOSE 80

# Comando padrão para iniciar o Nginx
CMD ["nginx", "-g", "daemon off;"]
