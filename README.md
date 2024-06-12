Transação é uma operação que necessita manter a consistência do banco de dados.

Precisa ter quatro propriedades, sendo:

	• Atomicity - ou acontece tudo ou nada;

	• Consistency - O dado precisa ser consistente, tanto no inicio quanto no fim;

	• Isolation - A transação precisa ser invisivel para as outras. Ou seja, quem transferiu o dinheiro não vê o saldo da conta futura e vice versa.

	• Durability - Após a transação ser efetivada e confirmada, não há como desfazer. Mesmo após falha no sistema.

Um bom exemplo disso é transação bancária. Imagine que você vá transferir dinheiro para uma conta e assim que o valor é debitado da sua conta acontece um erro no sistema atrapalhando o processo? Os dados ficarão incosistentes. Ou seja, na sua conta não terá dinheiro (será debitado) e na da Maria não terá dinheiro algum. 


Funções

setAutoCommit(false) - cada operação isolada que você fizer, será confirmada automaticamente de estiver true. Se você colocar false, as operações não serão confirmadas.

commit() - confirmar a transição.

rollback() - desfazer o que foi feito até o momento. Se ocorreu uma falha no meio da transação, você faz um rollback, voltando o estado do banco de dados (antes de começar a transação feita).

// COMO IMPEDIR O ERRO E PARAR A OPERAÇÃO AO DAR EXCEPTION? ![image](https://github.com/zenonxd/jdbc6/assets/64092861/c128fe15-c7b6-4dd8-b675-3ed890e35e8f)

Ao instanciar o conn.setAutoCommit ele diz: não é pra confirmar as operações automaticamente, tudo por padrão será pendente de uma confirmação explicita do programador.

Então depois de realizar as operações, colocamos:

![image](https://github.com/zenonxd/jdbc6/assets/64092861/5ebd859e-ae41-4879-a7ef-d1c9cec5233b)

E também colocamos uma condição dentro da exception.

![image](https://github.com/zenonxd/jdbc6/assets/64092861/a6749fb3-0532-40a4-b9a3-b5760abf5f6d)

Como o rollback pode dar uma exception, cercamos ele com try-catch.

![image](https://github.com/zenonxd/jdbc6/assets/64092861/61583839-f1cd-4107-a03e-a84faa84e8ee)

Dentro do try e catch, nós passamos duas exceções personalizadas. Uma pra dizer o motivo do roll back e outra, para dizer o motivo do roll back não ter acontecido.

