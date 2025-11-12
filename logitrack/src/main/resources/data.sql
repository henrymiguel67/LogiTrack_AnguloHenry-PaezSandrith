


INSERT INTO bodegas (nombre, ubicacion, capacidad, encargado) 
VALUES
    ('Bodega Central', 'Ciudad Principal', 5000, 'Juan Pérez'),
    ('Bodega Norte', 'Ciudad Norte', 3000, 'Ana González'),
    ('Bodega Sur', 'Ciudad Sur', 4000, 'Carlos Martínez');


INSERT INTO productos (nombre, categoria, stock, precio)
VALUES
    ('Producto A', 'Categoría 1', 100, 10.00),
    ('Producto B', 'Categoría 2', 200, 15.50),
    ('Producto C', 'Categoría 1', 50, 8.00),
    ('Producto D', 'Categoría 3', 30, 20.00);

INSERT INTO usuarios (username, password, rol, activo) 
VALUES
    ('admin', '1234', 'ADMIN', TRUE),
    ('empleado1', 'abcd', 'EMPLEADO', TRUE);


INSERT INTO movimientos (fecha, tipo, usuario_responsable_id, bodega_origen_id, bodega_destino_id, producto_id, cantidad)
VALUES
    ('2025-11-01 10:00:00', 'ENTRADA', 1, NULL, 1, 1, 100),
    ('2025-11-02 11:00:00', 'SALIDA', 2, 1, NULL, 1, 50),
    ('2025-11-03 12:00:00', 'TRANSFERENCIA', 1, 1, 2, 2, 20);


INSERT INTO auditoria (tipo_operacion, fecha_hora, usuario_id, entidad_afectada, valores_anteriores, valores_nuevos)
VALUES
    ('INSERT', '2025-11-01 10:00:00', 1, 'bodegas', NULL, '{"nombre": "Bodega Central", "ubicacion": "Ciudad Principal"}'),
    ('UPDATE', '2025-11-02 11:00:00', 2, 'productos', '{"stock": 100}', '{"stock": 50}'),
    ('DELETE', '2025-11-03 12:00:00', 1, 'movimientos', '{"cantidad": 20}', NULL);
