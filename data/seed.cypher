CREATE
(c1:Customer {
    customerId: 'CUST-001',
    name: 'Rahul Sharma',
    email: 'rahul@example.com'
}),
(c2:Customer {
    customerId: 'CUST-002',
    name: 'Priya Patel',
    email: 'priya@example.com'
}),
(c3:Customer {
    customerId: 'CUST-003',
    name: 'Amit Verma',
    email: 'amit@example.com'
}),

(a1:Account {
    accountId: 'ACC-001',
    status: 'ACTIVE'
}),
(a2:Account {
    accountId: 'ACC-002',
    status: 'ACTIVE'
}),
(a3:Account {
    accountId: 'ACC-003',
    status: 'ACTIVE'
}),
(a4:Account {
    accountId: 'ACC-004',
    status: 'ACTIVE'
}),

(d1:Device {
    deviceId: 'DEV-001',
    deviceType: 'Android'
}),
(d2:Device {
    deviceId: 'DEV-002',
    deviceType: 'iPhone'
}),
(d3:Device {
    deviceId: 'DEV-003',
    deviceType: 'Web'
}),

(m1:Merchant {
    merchantId: 'MER-001',
    name: 'Amazon'
}),
(m2:Merchant {
    merchantId: 'MER-002',
    name: 'Flipkart'
}),
(m3:Merchant {
    merchantId: 'MER-003',
    name: 'Myntra'
}),

(t1:Transaction {
    transactionId: 'TXN-001',
    amount: 2500,
    status: 'SUCCESS'
}),
(t2:Transaction {
    transactionId: 'TXN-002',
    amount: 7500,
    status: 'SUCCESS'
}),
(t3:Transaction {
    transactionId: 'TXN-003',
    amount: 15000,
    status: 'FLAGGED'
}),
(t4:Transaction {
    transactionId: 'TXN-004',
    amount: 1200,
    status: 'SUCCESS'
}),

(c1)-[:OWNS]->(a1),
(c2)-[:OWNS]->(a2),
(c2)-[:OWNS]->(a3),
(c3)-[:OWNS]->(a4),

(a1)-[:USES]->(d1),
(a2)-[:USES]->(d1),
(a2)-[:USES]->(d2),
(a3)-[:USES]->(d3),
(a4)-[:USES]->(d1),

(a1)-[:MADE]->(t1),
(a2)-[:MADE]->(t2),
(a3)-[:MADE]->(t3),
(a4)-[:MADE]->(t4),

(t1)-[:PAID_TO]->(m1),
(t2)-[:PAID_TO]->(m2),
(t3)-[:PAID_TO]->(m3),
(t4)-[:PAID_TO]->(m1)