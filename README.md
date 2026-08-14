# FraudGraph

FraudGraph is a small graph-based payment fraud investigation application built using Spring Boot and CognoDB.

The application helps investigators identify relationships between customers, accounts, devices, transactions, and merchants.

## Problem

In payment systems, fraud is often not visible from a single transaction.

For example, multiple accounts may use the same device. This can be a useful signal when investigating potentially suspicious activity.

FraudGraph allows an investigator to enter a customer ID and explore:

- Accounts owned by the customer
- Other accounts connected through a shared device
- Transactions made by the customer's accounts
- Merchants involved in those transactions

---

## Why a Graph Database?

The important information in this application is the relationship between entities.

For example:

Customer → Account → Device → Account → Customer

This type of multi-hop relationship is natural to represent and query using a graph database.

In a relational database, this investigation would require multiple tables and several JOIN operations.

With CognoDB, the same investigation can be expressed as a graph traversal:

```text
Customer
   |
  OWNS
   |
 Account
   |
  USES
   |
 Device
   |
  USES
   |
 Account