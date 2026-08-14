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

text
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
 
 
Graph Data Model
	Nodes
The application contains the following node types:

Customer
Account
Device
Transaction
Merchant


Relationships

Customer ──OWNS──> Account

Account ──USES──> Device

Account ──MADE──> Transaction

Transaction ──PAID_TO──> Merchant


Complete Model


                 ┌──────────────┐
                 │   Customer   │
                 └──────┬───────┘
                        │
                       OWNS
                        │
                        ▼
                 ┌──────────────┐
                 │   Account    │
                 └──────┬───────┘
                        │
                       USES
                        │
                        ▼
                 ┌──────────────┐
                 │    Device    │
                 └──────┬───────┘
                        │
                       USES
                        │
                        ▼
                 ┌──────────────┐
                 │   Account    │
                 └──────┬───────┘
                        │
                       MADE
                        │
                        ▼
                 ┌──────────────┐
                 │ Transaction  │
                 └──────┬───────┘
                        │
                     PAID_TO
                        │
                        ▼
                 ┌──────────────┐
                 │   Merchant   │
                 └──────────────┘

					
 Technology Stack
Java
Spring Boot
REST API
Neo4j Java Driver
CognoDB
Cypher
HTML
CSS
JavaScript
Maven


Running Locally

Prerequisites

Install:

Java 17+

Maven

Git

CognoDB account


Clone the Repository

git clone https://github.com/nikitawani86/fraudgraph-cognodb.git

cd fraudgraph-cognodb


Configure the CognoDB environment variables, load data/seed.cypher into CognoDB, and run:

mvn spring-boot:run

open: http://localhost:8080

Author

Nikita Wani

GitHub: https://github.com/nikitawani86/fraudgraph-cognodb
