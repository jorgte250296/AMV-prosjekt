create database if not exists AMV;
use AMV;
create table if not EXISTS tool
(
    Tool_id          smallint auto_increment,
    Tool_toolName    nvarchar(255) not null,
    Tool_description text,
    Tool_price       decimal,
    Tool_freeDayOne  bool     default true,
    ToolCategory_id  smallint,
    ToolStatus_id    smallint default 1,

    PRIMARY KEY (Tool_id),
    FOREIGN KEY (ToolCategory_id) REFERENCES toolCategory (ToolCategory_id) on delete set null,
    FOREIGN KEY (ToolStatus_id) REFERENCES toolStatus (ToolStatus_id) on delete set null
);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id,
                  ToolStatus_id)

values ('Eksentersliper 230VAC',
        'Papir kommer i tillegg.',
        20,
        true,
        3,
        2);


insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id,
                  ToolStatus_id)

values ('Båndsliper 230VAC',
        'Papir kommer i tillegg.',
        20,
        true,
        1,
        2);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id,
                  ToolStatus_id)

values ('Høvel 230VAC',
        20,
        true,
        1,
        2);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Gjære-/kombisag 230VAC',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('9’ vinkelsliper for stein og betong',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Meislemaskin, 230VAC',
        20,
        true,
        1);


insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Slagdrill, Batteri, Milwaukee',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Kantklipper -bensin',
        'Bruker oljeblandet bensin. Bruk kun ferdigblandet2-taktalkylatbensin (2%). Dette eroljeblandet spesialbensinenmed lang holdbarhet somkan kjøpes påbl.a. Felleskjøpet, Biltemaog Jula.',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Kompressor, 230VAC',
        'Maks. trykk: 10bar, Avgitt luftmengde: 255l/min, Effekt: 1,5kW.',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Diagnoseverktøy, bil',
        'Utstyres oppbevares hos Frank Welde. Brukermanual oppbevares i eske sammen med diagnoseverktøyet.',
        50,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Vibratorplate «Hoppetusse», bensin',
        'Vekt: 86 kg. Bruker ren bensin minimum oktantall 95. Motoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
        50,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Flisekutter for keramiskefliser',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Skruautomat',
        'Skruer kommer i tillegg. Se egen bruksanvisning vedlagt i oppbevaringskasse til skruautomat. Viktig å lese dette før bruk',
        20,
        true,
        1);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Motorisert trillebår',
        'Se egen bruksanvisning lagret her: K:\15 AMV velferd\Utstyr -velferden\Motorisert trillebår. Brukermanual er også lagret i beholder på selve utstyret. Viktig å lese dette før bruk. Bruk kun ren blyfri 95 oktan bensin. Sjekk alltid motoroljenivå før oppstart. Sørg for å få en rask opplæring i bruk av dette utstyret før første gangs bruk',
        50,
        true,
        1);

# Spikerpistoler o.l. Kategori ID 2.
insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Spikerpistol, stor (trykkluft)',
        20,
        true,
        2);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Spikerpistol, liten (trykkluft)',
        20,
        true,
        2);

insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Spikerpistol, stor (Milwaukee)',
        20,
        true,
        2);


insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Spikerpistol, mellom(Milwaukee)',
        20,
        true,
        2);


insert into tool (Tool_toolName,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Spikerpistol, liten (Milwaukee)',
        20,
        true,
        2);

# Utstyr for vedhogst. Kategori ID 3.
insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Vedkløyver, Bensindrevet',
        'Bruker ren bensin,minimum oktantall 95. Motoroljenivå sjekkes før og etter bruk. Oljetype: ShellUltra Ect 5W-30 (AMV nr. 0095-0069). Hydraulikkoljenivå sjekkes før og etter bruk. Oljetype: Shell Tellus S2VX46 (AMV nr. 0095-0006). Kløyveren har ikke fjæring og tyngdepunktet er forholdsvis høyt så det må utvises forsiktighet med sleping etter kjøretøy. Dvs. tilpass farten etter forholdene.',
        50,
        true,
        3);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Fliskutter for trevirke',
        'Se egen bruksanvisning lagret her: K:\15 AMV velferd\Utstyr -velferden\Fliskutter. Brukermanual er også lagret i beholder på selve utstyret. Viktig å lese dette før bruk!. Bruk kun ren blyfri 95 oktan bensin. Sjekk alltid motoroljenivå før oppstart. Sørg for å få en rask opplæring i bruk av dette utstyret før første gangs bruk',
        50,
        true,
        3);

# Tilhenger, kategori-ID 4
insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Tilhenger, boggi; RD 5702',
        'Kassemål LxBxH: 297x153x29cmNyttelast max. 1150kg. Se informasjonssside',
        50,
        true,
        4);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Tilhenger, liten, RC 8834',
        'Kassemål LxBxH: 197x153x29cm. Nyttelast max. 645kg. Se informasjonssisde.',
        50,
        true,
        4);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Tilhenger, skap, JP2591',
        'Kassemål innv. LxBxH: 292x154x194cm. (Dørkarm BxH: 146x190cm) Nyttelast: 1090 kg. Se informasjonssisde.',
        50,
        true,
        4);


# Større utstyr, kategori-ID 5
insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Personløfter, arb. høyde 12m. SWL 200kg, 230 VAC',
        'Dette utstyret kan kun benyttes av personer som har hatt dokumentert sikkerhetsopplæringiht. Forskrift om utførelse av arbeid §10-1 og 10-2. En slik opplæring består av teoretisk og praktisk opplæringsom gir kunnskap om oppbygging, betjening, bruksegenskaper og bruksområde samt vedlikehold og kontroll. Kursbevisutstedestil de som har gjennomført dette kurset',
        100,
        false,
        5);

insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Strømaggregat, 3.7 kW (Diesel',
        'Bruker avgiftsfri diesel. Motoroljenivå sjekkes førog etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
        50,
        true,
        5);


insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Dekkomleggingsmaskin',
        'Se informasjonssside.',
        0,
        true,
        5);


insert into tool (Tool_toolName,
                  Tool_description,
                  Tool_price,
                  Tool_freeDayOne,
                  ToolCategory_id)

values ('Avbalanseringsmaskin',
        'Se informasjonssside.',
        0,
        true,
        5);


insert into tool (Tool_toolName,
                  Tool_description,
                  ToolCategory_id)

values ('Leilighet på Hovden',
        'Kontakt resepsjonen hos AMV.',
        5);

