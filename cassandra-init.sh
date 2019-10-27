CQL="CREATE KEYSPACE IF NOT EXISTS shopping_cart_poc WITH replication = {'class': 'SimpleStrategy', 'replication_factor':'1'};
CREATE TABLE shopping_cart_poc.product (product_id text, product_name text, product_price int, PRIMARY KEY (product_id));"


until echo $CQL | cqlsh; do
    echo "cqlsh: Cassandra is not available - retry later"
    sleep 2
done &

exec /docker-entrypoint.sh "$@"