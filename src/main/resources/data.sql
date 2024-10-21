INSERT INTO users(id, firstname, lastname, password, username)
SELECT '292ae53a-f82c-41d6-b528-884a7d71e4b2', 'Jan', 'Novák', '$2a$10$SfSJDmtcDbzJc6Qy3.r8vOu9GjGsQpjhv9z6Z342JsNemASxNVeG.', 'jan.novak@actumdigital.com'
    WHERE NOT EXISTS (SELECT 1 FROM users);

INSERT INTO products (code, name, description, price)
SELECT * FROM (SELECT 'PR0001', 'Infotainment Online', 'Se službami Infotainment Online od Škoda Connect budete na cestách lépe informováni. Vyhledávejte zajímavé cíle ve svém okolí, získávejte aktuální dopravní informace přímo z internetu a mnoho dalších možností.', 1999
               UNION ALL
               SELECT 'PR0002', 'Care Connect - Vzdálený přístup', 'Potřebujete odemknout či zamknout svůj vůz Škoda, ale jste od něj příliš daleko? Tato funkce může výrazně zjednodušit mnohé problematické situace, například když zapomenete auto zamknout nebo když do něj chcete pustit někoho jiného. Umožňuje vám odemknout a zamknout vaše vozidlo pomocí portálu Škoda Connect nebo aplikace MyŠkoda. Funguje na jakoukoliv vzdálenost.', 1499
               UNION ALL
               SELECT 'PR0003', 'Online data - Travel Assist, Media Streaming', 'Travel Assist obsahuje celou řadu asistenčních systémů, mezi které patří například prediktivní tempomat, adaptivní vedení v jízdním pruhu nebo vylepšená verze rozpoznávání dopravních značek. Balíčkem Media Streaming získáte mobilní datový přístup (poskytuje Škoda Auto), který je nezbytný pro poslech WebRadia.', 999
               UNION ALL
               SELECT 'PR0004', 'Online data - Intelligent Speed Assist, Traffication', 'Aplikace Traffication v infotainment systému vás informuje o dění na silnici a může vás dokonce varovat, pokud vjíždíte na dálnici v nesprávném směru', 999
              ) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products);

INSERT INTO products (code, name, description, price)
SELECT * FROM (SELECT 'PR0001', 'Infotainment Online - 1 rok', 'Se službami Infotainment Online od Škoda Connect budete na cestách lépe informováni. Vyhledávejte zajímavé cíle ve svém okolí, získávejte aktuální dopravní informace přímo z internetu a mnoho dalších možností.', 1999
               UNION ALL
               SELECT 'PR0002', 'Care Connect - Vzdálený přístup - 1 rok', 'Potřebujete odemknout či zamknout svůj vůz Škoda, ale jste od něj příliš daleko? Tato funkce může výrazně zjednodušit mnohé problematické situace, například když zapomenete auto zamknout nebo když do něj chcete pustit někoho jiného. Umožňuje vám odemknout a zamknout vaše vozidlo pomocí portálu Škoda Connect nebo aplikace MyŠkoda. Funguje na jakoukoliv vzdálenost.', 1499
               UNION ALL
               SELECT 'PR0003', 'Online data - Travel Assist, Media Streaming', 'Travel Assist obsahuje celou řadu asistenčních systémů, mezi které patří například prediktivní tempomat, adaptivní vedení v jízdním pruhu nebo vylepšená verze rozpoznávání dopravních značek. Balíčkem Media Streaming získáte mobilní datový přístup (poskytuje Škoda Auto), který je nezbytný pro poslech WebRadia.', 999
               UNION ALL
               SELECT 'PR0004', 'Online data - Intelligent Speed Assist, Traffication', 'Aplikace Traffication v infotainment systému vás informuje o dění na silnici a může vás dokonce varovat, pokud vjíždíte na dálnici v nesprávném směru', 999
              ) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM products);

INSERT INTO purchased_licenses(end_date, product_code, user_id)
SELECT '2025-06-27', 'PR0001', '292ae53a-f82c-41d6-b528-884a7d71e4b2'
WHERE NOT EXISTS (SELECT 1 FROM purchased_licenses);