# Stack Calculator – Softwareentwicklungsmodelle

In diesem Projekt erweitert ihr einen kleinen Taschenrechner. Ihr übt Git,
automatisierte Tests und die Zusammenarbeit in eurer Moodle-Gruppe.

## Einstieg

1. **Eine Person pro Moodle-Gruppe** öffnet
   [g4e817/calculator-template](https://github.com/g4e817/calculator-template)
   und erstellt über **Fork** einen Fork im eigenen GitHub-Konto.
   Name: `calculator-gruppe-a`, `calculator-gruppe-b`, `calculator-gruppe-c`
   oder `calculator-gruppe-g`, passend zur Gruppe. Kopiert nur den Branch `main`.
2. Diese Person lädt die anderen Gruppenmitglieder unter **Settings → Collaborators**
   ein. Alle nehmen die Einladung an und arbeiten in diesem gemeinsamen Fork.
3. Aktiviert **Issues** unter **Settings → General → Features** und den vorhandenen
   Workflow im Tab **Actions**, falls GitHub euch dazu auffordert.
4. Meldet der Lehrperson in Moodle eure Gruppe, Mitglieder mit GitHub-Benutzernamen
   und den Link zum Gruppen-Fork.
5. Alle klonen **denselben Gruppen-Fork** über **Code → HTTPS** und öffnen die
   `pom.xml` als Maven-Projekt in ihrer IDE.
6. Prüft eure Java- und Maven-Version und führt die vorhandenen Tests aus.

Ein Fork ist eure eigene Kopie auf GitHub; Klonen lädt diese Kopie auf euren
Computer. Für diese Übung verwendet ihr **Fork**, nicht **Use this template**.
Das Ausgangsprojekt und eure Forks sind öffentlich. In das Repository gehören
eure GitHub-Benutzernamen; vollständige Namen und deren Zuordnung meldet ihr in Moodle.

```sh
java -version
mvn -version
mvn --batch-mode clean verify
```

Voraussetzungen: **JDK 21**, Maven 3.9 oder neuer und Git. Auch die Ausgabe von
`mvn -version` muss Java 21 anzeigen. Stellt in der IDE sowohl das Projekt-JDK
als auch das JDK des Maven-Runners auf 21 ein.

Der Ausgangsstand enthält **8 Tests**. Ein erfolgreicher Lauf endet mit
`BUILD SUCCESS`. Das Projekt wird über die Tests ausgeführt; es enthält keine
Kommandozeilenanwendung mit einer `main`-Methode.

## Anleitungen

| Dokument | Inhalt |
| --- | --- |
| [Aufgaben](docs/AUFGABEN.md) | Modulo, E2E-Tests, sin/cos, Skalarprodukt und CI |
| [Zusammenarbeit](docs/ZUSAMMENARBEIT.md) | Arbeitsteams, Pair Programming und Reviews |
| [Abgabe](docs/ABGABE.md) | Checkliste, GitHub-Release und Einreichung in Moodle |
| [Abgabevorlage](ABGABE.md) | Gruppenmitglieder, erledigte Aufgaben und Nachweise |

Die Moodle-Gruppen A, B und C arbeiten mit je vier Personen in zwei Zweierteams.
Gruppe G bleibt mit fünf Personen zusammen und bildet ein Zweierteam und ein
Dreierteam mit wechselnden Rollen. Jede Gruppe arbeitet in ihrem gemeinsamen Fork.

Pull Requests gehen an `main` **im eigenen Gruppen-Fork**. Die Abgabe erfolgt als
Release in diesem Fork; den Release-Link reicht eine Person für die Gruppe in Moodle ein.

**Beginn:** Projekt starten, dann nach Freigabe der Lehrperson Aufgaben 1 und 2
bearbeiten. Weitere Aufgaben und verbindliche Abgabetermine kündigen die
Lehrenden im Kurs an. Es gibt in dieser Vorlage keine vorgegebenen Fristen.

## Aufbau des Projekts

| Datei bzw. Verzeichnis | Aufgabe |
| --- | --- |
| `src/main/java/at/campus02/swe/Calculator.java` | Schnittstelle und bekannte Operationen |
| `src/main/java/at/campus02/swe/logic/CalculatorImpl.java` | Stapel und Rechenlogik |
| `src/main/java/at/campus02/swe/parser/Parser.java` | XML einlesen und an den Calculator weitergeben |
| `src/test/java/` | Vorhandene und neue JUnit-Tests |
| `src/test/resources/` | XML-Dateien für Tests |
| `.github/workflows/maven.yml` | Vorhandener Build- und Testworkflow für GitHub |

Das Projekt verwendet **JUnit 4.13.1** und Mockito. Verwendet für neue Tests die
JUnit-4-Imports, beispielsweise `org.junit.Test`. Die optionalen Jupiter-Beispiele
aus den Folien benötigen andere Abhängigkeiten und gehören nicht zum Einstieg.

## Wie der Calculator rechnet

`push` legt eine Zahl oben auf den Stapel, `pop` entfernt die oberste Zahl.
Bei einer Rechnung mit zwei Zahlen wird zuerst die zuletzt abgelegte Zahl
entnommen. Legt ihr zuerst `6`, dann `2` ab, ergibt die Division `6 / 2 = 3`.

Eine Operation liefert ihr Ergebnis zurück. Sie legt es **nicht automatisch**
wieder auf den Stapel. In XML könnt ihr das zuletzt berechnete Ergebnis mit
`<push value="Result" />` erneut verwenden.

```xml
<calculation>
    <push value="6" />
    <push value="2" />
    <operation value="/" />
</calculation>
```

Diese Rechnung ergibt `3`. Weitere Ausgangsbeispiele findet ihr in
`src/test/resources/`.

## Ausgangspunkt

Grundlage ist [Valerionn/fh-campus02-swe-2025](https://github.com/Valerionn/fh-campus02-swe-2025),
Stand `4197487625b84ad7a3bb86e1aece2327752279b3`.
Die vorhandene Implementierung und ihre Tests bilden den Ausgangspunkt für die Übungen.
