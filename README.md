# dell-tag-query

A Clojure Application to query the Dell Service Catalog with a service tag and return the system catalog information


## Requirements

Java JVM .= 1.8


## Usage

```java -jar dell-tag-query.jar <service-tag>```


## Install from NPM

sudo npm install dell-tag-query -g


Example output

```
| Service Tag | Computer Model | Shipping Date |       Country |
|-------------+----------------+---------------+---------------|
|     2FZDR22 | PowerEdge R630 |    11/19/2014 | United States |

| :Qty |                                                                               :Description | :PartNumber |
|------+--------------------------------------------------------------------------------------------+-------------|
|    1 |                                               LABEL, BARCODE, TRACK, SYSTEM BOARD, GENERIC |       23503 |
|    1 |                                  ASSEMBLY, PRINTED WIRING ASSY, PLANAR (MOTHERBOARD), R630 |       CNCJW |
|    1 |                                                 GUIDE, PRODUCT, INFORMATION, SERI, DAO/BCC |       J894K |
|    1 | PRINTED WIRING ASSY, PLANAR (MOTHERBOARD), 12G, RNDC, BROADCOM CORPORATION, QP, 1G, COPPER |       FM487 |
|    1 |                                                       ASSEMBLY, CABLE, MPERC, 8, APL, R630 |       K43RY |
|    1 |                                               ASSEMBLY, BEZEL, FRONT, METAL, 8HDD, 1U, 13G |       3FJR9 |
|    1 |                              ASSEMBLY, CARD (CIRCUIT), CONTROLLER, H730, 1GB, NV, MINICARD |       KMCCD |
|    1 |                                                     PROCESSOR, E52603V3, 1.6, 15M, HSL, R2 |       C1J8J |
|    1 |                                                     PROCESSOR, E52603V3, 1.6, 15M, HSL, R2 |       C1J8J |
|    2 |                                  DUAL IN-LINE MEMORY MODULE, 16GB, 2133, 2RX4, 4G, DDR4, R |       1R8CR |
|    2 |                                 HARD DRIVE, 1T, EXPANDABLE SYSTEM, 7.2K, 2.5, 6, S-AW, E/C |       9KW4J |
|    1 |                        KIT, MEDIA, DIGITAL VIDEO DISK DRIVE, DOCUMENT OBJECT MODEL, V8.0.1 |       J5CN0 |
|    1 |                                         ASSEMBLY, DIGITAL VIDEO DISK DRIVE, 8X, 9.5T, PLDS |       C8XM5 |
|    1 |                                           KIT, RACK RAIL, CABLE MANAGEMENT ARM, SPRING, 1U |       2J1CF |
|    2 |                                                 POWER SUPPLY, 750W, REDUNDANT, 13G, LITEON |       HTRH4 |
|    2 |                                               CORD, POWER, 13A, 2F, C13/C14, UNITED STATES |       95DYN |
|   22 |                                   FILLER, BLANK , DUAL IN-LINE MEMORY MODULE, PLASTIC, 13G |       5M8WD |
|    2 |                                                             ASSEMBLY, HEATSINK, 120W, R630 |       H1M29 |
```


## License

Copyright © 2017 Gary Berger

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
