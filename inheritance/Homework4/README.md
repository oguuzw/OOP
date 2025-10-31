# Homework4 - Cargo Management System

This project is a Java application for managing shipments in different categories. It is developed using Object-Oriented Programming (OOP) principles.

## 📋 Project Description

The Cargo Management System is a console application that manages 5 different cargo categories and performs various operations. The system provides special features and methods for each category using inheritance structure.

## 🗂️ Cargo Categories

1. **Electronics** (`ElektronikGonderi_2433`)
2. **Books** (`KitapGonderi_2433`)
3. **Clothing** (`GiyimGonderi_2433`)
4. **Office** (`OfisGonderi_2433`)
5. **Food** (`GidaGonderi_2433`)

## 🏗️ Class Structure

### Base Class: `Gonderi_2433`

The base class from which all cargo categories inherit.

**Properties:**
- `gonderiAdi`: Shipment name
- `kategoriIndex`: Category number (1-5)
- `agirlik`: Weight (kg)
- `kargoUcreti`: Cargo fee (TL)
- `teslimSuresi`: Delivery time (days)

**Methods:**
- `teslimSuresineGoreKargoUcretiGuncelle(int sure, double guncelUcret)`: Updates the fee for shipments with delivery times longer than the specified time
- `enHafifGonderiyeEkUcretUygula(double oran)`: Applies an additional fee to the lightest shipment at a specified rate

### Subclasses

#### 1. `ElektronikGonderi_2433`
- **Additional Properties:** `kategoriAdi`, `detay`
- **Special Method:** `elektronikGonderiAgirlikGuncelle(double miktar)` - Randomly updates the weights of electronic shipments

#### 2. `KitapGonderi_2433`
- **Additional Properties:** `kategoriAdi`, `detay`
- **Special Method:** `kitapGonderiSuresiGuncelle(int index, int yeniSure)` - Updates the delivery time of the book shipment at a specific index

#### 3. `GiyimGonderi_2433`
- **Additional Properties:** `kategoriAdi`, `detay`
- **Special Method:** `giyimGonderiDetayEkle(String adi, String yeniDetay)` - Adds new details to a clothing shipment

#### 4. `OfisGonderi_2433`
- **Additional Properties:** `kategoriAdi`, `detay`
- **Special Method:** `ofisGonderileriniSil(double minUcret, double maxUcret)` - Deletes office shipments within a specified fee range

#### 5. `GidaGonderi_2433`
- **Additional Properties:** `kategoriAdi`, `detay`
- **Special Method:** `gidaGonderisiEkle(String adi, double agirlik, double ucret, int teslimSuresi)` - Adds a new food shipment

## 🎯 Main Program: `Main_2433`

### Menu Options

1. **Update Cargo Fee Based on Delivery Time**
   - Updates the fee for shipments with delivery times longer than the entered time
   - Formula: `newFee = currentFee * (1 + (deliveryTime - time) / 10.0)`

2. **Apply Additional Fee to Lightest Shipment**
   - Finds the lightest shipment among all categories
   - Adds an additional fee at the specified rate

3. **Update Electronic Shipment Weight**
   - Randomly increases or decreases the weights of electronic shipments
   - Update amount is determined by the user

4. **Update Book Shipment Time**
   - Changes the delivery time of the book shipment at a specific index

5. **Add Clothing Shipment Details**
   - Adds new detail information to the selected clothing shipment

6. **Delete Office Shipments**
   - Removes office shipments within the specified fee range from the list

7. **Add Food Shipment**
   - Adds a new food shipment

8. **Exit**

## 📂 Data Files

The project uses two data files:

1. **`KargoOdev4.txt`**: Contains cargo information
   - Format: `ShipmentName | CategoryIndex | Weight | CargoFee | DeliveryTime`

2. **`KargoGrubuOdev4.txt`**: Contains category details
   - Format: `CategoryIndex | Name | Details`

## 💻 Usage

```java
// Start the program
java Main_2433

// Create lists
listeleriOlustur("KargoOdev4.txt");
kargoGrubuEkle("KargoGrubuOdev4.txt");

// Use menu
menu();
```

## 🔧 Important Methods

### `listeleriOlustur(String dosyaAdi)`
Reads the cargo file and transfers it to category-based lists.

### `kargoGrubuEkle(String dosyaAdi)`
Adds category details to the relevant shipments.

### `menu()`
Runs the main menu loop for user interaction.

## 📊 Data Structure

Static `ArrayList` is used for each category:
- `ElektronikGonderi_2433.list`
- `KitapGonderi_2433.list`
- `GiyimGonderi_2433.list`
- `OfisGonderi_2433.list`
- `GidaGonderi_2433.list`

## 🎓 OOP Principles

OOP concepts used in this project:
- ✅ **Inheritance**: All category classes are derived from the `Gonderi_2433` class
- ✅ **Encapsulation**: Each class contains its own properties and methods
- ✅ **Polymorphism**: The same operations can be applied to different category lists

## 📝 Notes

- File paths are defined as absolute paths, you may need to update them according to your system
- All methods can throw `IOException`
- User inputs are received with the `Scanner` class

## 🚀 Development Ideas

- [ ] Database integration
- [ ] Add GUI interface
- [ ] Cargo tracking system
- [ ] Reporting features
- [ ] Statistical analysis

---
 
**Project:** Object-Oriented Programming - Homework 4
