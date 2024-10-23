INSERT INTO addresses (id, street, city, postal_code, address_type, country)
SELECT
    '9314997c-c2a2-4ee3-aafb-af3166751c5e',
    'Ulice',
    'Mesto',
    '10000',
    'BILLING',
    'CZECHIA'
    WHERE NOT EXISTS (SELECT 1 FROM addresses);

INSERT INTO users(id, firstname, lastname, password, username, phone_number, address_id)
SELECT '292ae53a-f82c-41d6-b528-884a7d71e4b2', 'Jan', 'Novák', '$2a$10$SfSJDmtcDbzJc6Qy3.r8vOu9GjGsQpjhv9z6Z342JsNemASxNVeG.', 'jan.novak@actumdigital.com', '+420777555333', '9314997c-c2a2-4ee3-aafb-af3166751c5e'
    WHERE NOT EXISTS (SELECT 1 FROM users);

INSERT INTO categories (id, name)
SELECT id, name
FROM (VALUES
          ('a3e1b3d5-4cf1-4d77-9b9e-6e34a574d2a9'::uuid, 'Tarif Powerpass'),
          ('b2f4d4a5-23f5-48da-a12b-7c56a0e9f8b8'::uuid, 'Skoda Connect services'),
          ('c1d8f6b2-94e8-42f5-9c82-8a32c1e1db13'::uuid, 'Infotainment app')
     ) AS names(id, name)
WHERE NOT EXISTS (SELECT 1 FROM categories);

INSERT INTO products (id, code, name, description, price, product_type, category_id)
SELECT * FROM (SELECT '9a500514-e9bb-40c2-a99c-b96cc67e9ca2'::uuid,'PR0001', 'Infotainment Online - 1 rok', 'Se službami Infotainment Online od Škoda Connect budete na cestách lépe informováni. Vyhledávejte zajímavé cíle ve svém okolí, získávejte aktuální dopravní informace přímo z internetu a mnoho dalších možností.', 1999, 'SERVICE','b2f4d4a5-23f5-48da-a12b-7c56a0e9f8b8'::uuid
               UNION ALL
               SELECT '6f4e4a37-36c6-43b2-8666-0b3ff53c7a2c'::uuid,'PR0002', 'Care Connect - Vzdálený přístup - 1 rok', 'Potřebujete odemknout či zamknout svůj vůz Škoda, ale jste od něj příliš daleko? Tato funkce může výrazně zjednodušit mnohé problematické situace, například když zapomenete auto zamknout nebo když do něj chcete pustit někoho jiného. Umožňuje vám odemknout a zamknout vaše vozidlo pomocí portálu Škoda Connect nebo aplikace MyŠkoda. Funguje na jakoukoliv vzdálenost.', 1499, 'PACKAGE', 'b2f4d4a5-23f5-48da-a12b-7c56a0e9f8b8'::uuid
               UNION ALL
               SELECT '640df035-7874-4f22-afb6-6ad9a8e74f41'::uuid,'PR0003', 'Online data - Travel Assist, Media Streaming', 'Travel Assist obsahuje celou řadu asistenčních systémů, mezi které patří například prediktivní tempomat, adaptivní vedení v jízdním pruhu nebo vylepšená verze rozpoznávání dopravních značek. Balíčkem Media Streaming získáte mobilní datový přístup (poskytuje Škoda Auto), který je nezbytný pro poslech WebRadia.', 999, 'SERVICE','b2f4d4a5-23f5-48da-a12b-7c56a0e9f8b8'::uuid
               UNION ALL
               SELECT '4492c542-d7f3-40d5-abfb-e37558aeac81'::uuid,'PR0004', 'Online data - Intelligent Speed Assist, Traffication', 'Aplikace Traffication v infotainment systému vás informuje o dění na silnici a může vás dokonce varovat, pokud vjíždíte na dálnici v nesprávném směru', 999, 'SERVICE','b2f4d4a5-23f5-48da-a12b-7c56a0e9f8b8'::uuid
              ) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products);

INSERT INTO purchased_licenses(end_date, product_id, user_id)
SELECT '2025-06-27', '9a500514-e9bb-40c2-a99c-b96cc67e9ca2'::uuid, '292ae53a-f82c-41d6-b528-884a7d71e4b2'
WHERE NOT EXISTS (SELECT 1 FROM purchased_licenses);