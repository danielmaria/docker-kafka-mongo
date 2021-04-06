cd notificacoes-sms
mvn clean package
docker build -t notificacoes-sms .
cd ..
cd movimentacao-financeira
mvn clean package
docker build -t movimentacao-financeira .
cd ..
cd pagamento-cartao-credito
mvn clean package
docker build -t pagamento-cartao-credito .
docker-compose up
