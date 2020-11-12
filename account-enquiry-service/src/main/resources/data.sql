DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS account_transactions;
CREATE TABLE accounts (
    account_number varchar(16) PRIMARY KEY,
    account_name varchar(255) NOT NULL,
    account_type varchar(15) NOT NULL,
    balance_date DATE NOT NULL,
    currency varchar(3) NOT NULL,
    user_id INT NOT NULL
);
CREATE TABLE account_transactions (
    transaction_id INT NOT NULL,
    account_number varchar(16) NOT NULL,
    debit_amount decimal default NULL,
    credit_amount decimal default NULL,
    transaction_type varchar(15) NOT NULL,
    transaction_date TIMESTAMP NOT NULL,
    transaction_narrative varchar(max) DEFAULT NULL,
    FOREIGN KEY (account_number) references accounts(account_number),
    PRIMARY KEY(transaction_id, account_number)
);

INSERT INTO accounts(account_number, account_name, account_type, balance_date, currency, user_id)
    values ('123456789', 'Savings1', 'Savings', '2019-09-19', 'INR', 1);
INSERT  INTO accounts(account_number, account_name, account_type, balance_date, currency, user_id)
    values ('1234', 'Savings', 'Savings', '2019-09-19', 'INR', 2);
INSERT  INTO accounts(account_number, account_name, account_type, balance_date, currency, user_id)
    values ('123456', 'Savings', 'Savings', '2019-09-19', 'USD', 2);
INSERT  INTO accounts(account_number, account_name, account_type, balance_date, currency, user_id)
    values ('5678', 'Current', 'Current', '2019-09-19', 'INR', 3);


INSERT INTO account_transactions(transaction_id, account_number, credit_amount,
                                    transaction_type, transaction_date, transaction_narrative)
    values (1 , '1234', 40000, 'Credit', {ts '2019-09-01 18:47:52.69'}, 'Salary Credited');

INSERT INTO account_transactions(transaction_id, account_number, credit_amount,
                                    transaction_type, transaction_date, transaction_narrative)
    values (2 , '1234', 2000, 'Credit', {ts '2019-09-01 18:47:52.69'}, 'Interest Credited');

INSERT INTO account_transactions(transaction_id, account_number, debit_amount,
                                    transaction_type, transaction_date)
    values (3 , '1234', 1500, 'Debit', {ts '2019-09-01 18:47:52.69'});

INSERT INTO account_transactions(transaction_id, account_number, debit_amount,
                                    transaction_type, transaction_date)
    values (4 , '1234', 120, 'Debit', {ts '2019-09-01 18:47:52.69'});

INSERT INTO account_transactions(transaction_id, account_number, credit_amount,
                                    transaction_type, transaction_date)
    values (1 , '123456', 1200, 'Credit', {ts '2019-09-01 18:47:52.69'});

INSERT INTO account_transactions(transaction_id, account_number, credit_amount,
                                    transaction_type, transaction_date)
    values (2 , '123456', 10, 'Credit', {ts '2019-09-01 18:47:52.69'});
INSERT INTO account_transactions(transaction_id, account_number, debit_amount,
                                    transaction_type, transaction_date)
    values (3 , '123456', 100, 'Debit', {ts '2019-09-01 18:47:52.69'});