-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 16, 2017 at 01:36 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `newehutdb1`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `password`) VALUES
(1, 'adone', 'ad@ad.ad', 'e10adc3949ba59abbe56e057f20f883e'),
(2, 'ad', 'a@a.a', '6cf82ee1020caef069e753c67a97a70d'),
(3, 'ad', 'ad@ad.ad', '662be8a28444fe9b80595f92b8493fc4');

-- --------------------------------------------------------

--
-- Table structure for table `billinginfo`
--

CREATE TABLE `billinginfo` (
  `id` int(11) NOT NULL,
  `CreditCardNo` int(10) NOT NULL,
  `CreditCardPin` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billinginfo`
--

INSERT INTO `billinginfo` (`id`, `CreditCardNo`, `CreditCardPin`) VALUES
(57, 15978965, 25348973);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts`
--

CREATE TABLE `cartproducts` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts`
--

INSERT INTO `cartproducts` (`id`, `name`, `description`, `image`, `price`) VALUES
(1, 'Dell XPS 13', 'CPU: Intel Core i3 - i7\r\n\r\nGraphics: Intel HD Graphics 620 \r\n\r\nScreen: 13.3-inch FHD (1,920 x 1,080) - QHD+ (3,200 x 1,800) \r\n\r\nStorage: 128GB - 512GB SSD\r\n', 'Dell XPS 13.png', 98862.20),
(2, 'Dell Latitude ', 'CPU : Intel Core i7-7600U\r\nOperating System : Windows 10 Pro\r\nRAM : 16GB\r\nHard Drive Size : 256GB\r\nHard Drive Type : M.2 SATA Class 20 SSD\r\nDisplay Size : 12.5\r\nGraphics Card : Intel HD 620 Graphics\r\nTouchpad Size : 3.9 x 2.1 inches\r\nSize : 12.0 x 8.3 x 0.8 inches', 'Dell Latitude.png', 129565.89),
(3, 'Dell Precision ', 'CPU : 2.9-GHz Intel Core i7-7820HQ CPU\r\nOperating System : Windows 10 Pro\r\nRAM : 32GB\r\nHard Drive Size : 512GB SSD\r\nDisplay Size : 15.6\r\nGraphics Card : NvidiaQuadro M620 2GB / Intel HD Graphics 630\r\nTouchpad Size : 4 x 2 inches\r\nSize : 14.6 x 9.9 x 0.97 inches', 'Dell Precision.png', 152457.39),
(4, 'Dell Inspiron 13 7000 ', 'CPU : 2.5 GHz Intel Core i5-7200U\r\nOperating System : Windows 10 Home\r\nRAM : 16GB\r\nHard Drive Size : 256GB SSD\r\nDisplay Size : 13.3\r\nHighest Available Resolution : 1920 x 1080\r\nGraphics Card : Intel HD Graphics 620\r\nTouchpad Size : 4.5 x 2.6 inches\r\nSize : 12.7 x 8.8 x 0.8 inches', 'Dell Inspiron.png', 106825.47),
(5, 'Dell Inspiron 17 7000 2-in-1', 'CPU : 2.7-GHz Intel Core i7-7500U CPU\r\nOperating System : Windows 10 Home\r\nRAM : 16GB\r\nHard Drive Size : 1 TB\r\nHard Drive Type : Serial ATA\r\nSecondary Hard Drive : Size 128 GB\r\nSecondary Hard Drive Type : SSD\r\nDisplay Size : 17.3\r\nHighest Available Resolution : 1920 x 1080\r\nNative Resolution : 1920x1080', 'Dell Inspiron 17 7000 2-in-1.png', 137347.47);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts2`
--

CREATE TABLE `cartproducts2` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts2`
--

INSERT INTO `cartproducts2` (`id`, `name`, `description`, `image`, `price`) VALUES
(6, 'Asus ZenBook UX305', 'CPU: Intel Core Intel Core M3-6Y30 - M7-6Y75 \r\n\r\nGraphics: Intel HD Graphics 515 \r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) - QHD+ (3200 x 1800) IPS display \r\n\r\nStorage: 256GB - 512GB SSD', 'Asus ZenBook UX305.png', 98862.17),
(7, 'Asus Chromebook Flip', 'CPU: Intel Pentium - Core m3 \r\n\r\nGraphics:Intel HD Graphics 515 \r\n\r\nScreen: 12.5-inch, FHD (1,920 x 1,080) LED backlit anti-glare \r\n\r\nStorage: 32GB - 64GB eMMC', 'Asus Chromebook Flip .png', 76012.67),
(8, 'Asus ZenBook Flip UX360', 'CPU: Intel Core m3 â€“ Core m7 \r\n\r\nGraphics: Intel HD Graphics 515 \r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) LED-backlit glare touchscreen \r\n\r\nStorage: 128GB â€“ 512GB SSD', 'Asus ZenBook Flip UX360.png', 84695.48),
(9, 'Asus - 2-in-1 15.6\" 4K UHD Touch-Screen Laptop', 'Model : Q534UX-BHI7T19\r\nIntel Core i7\r\n16GB Memory\r\nNVIDIA GeForce GTX 950M\r\n2TB HDD + 512GB SSD\r\nChocolate black aluminum hairline with dark copper', 'Asus  Touch-Screen Laptop.png', 152610.00),
(10, 'Asus - Q524UQ 2-in-1 15.6\" Touch-Screen Laptop', 'Intel Core i7\r\n12GB Memory\r\nNVIDIA GeForce 940MX\r\n2TB Hard Drive\r\nSandblasted black aluminum with gunmetal hinge\r\nModel : Q524UQ-BHI7T1', 'Asus Q524UQ in1 15.6Touch-Screen Laptop.png', 152608.47);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts3`
--

CREATE TABLE `cartproducts3` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts3`
--

INSERT INTO `cartproducts3` (`id`, `name`, `description`, `image`, `price`) VALUES
(11, 'MacBook', 'CPU: Intel Core m3 â€“ m5 \r\n\r\nGraphics:Intel HD Graphics 515 \r\n\r\nScreen: 12-inch, 2304 x 1,440 LED-backlit IPS display \r\n\r\nStorage: 256GB â€“ 512GB SSD\r\n', 'MacBook.png', 231389.27),
(12, 'MacBook Pro (15-inch, Late 2016)', 'CPU: Intel Core i7 \r\n\r\nGraphics:AMD Radeon Pro 450 â€“ 460 \r\n\r\nScreen: 15.4-inch Retina (2,880 x 1,800) LED-backlit IPS \r\n\r\nStorage: 256GB â€“ 2TB PCIe SSD', 'MacBook-Pro-(15-inch,-Late-2016).png', 342590.17),
(13, 'A1181 Macbook MB403LL', 'Screen Size : 13.3 inches\r\nProcessor : 2.1 GHz Intel Core 2 Duo Mobile\r\nRAM : 2 GB ddr2_sdram\r\nHard Drive : 120 GB mechanical_hard_drive\r\nGraphics Coprocessor : integrated_graphics\r\nChipset Brand : intel\r\nProcessor Brand : Intel', 'A1181 Macbook MB403LL.png', 137349.00),
(14, 'Apple MacBook MLH82LL/A', 'Screen Size : 13.3 inches\r\nMax Screen Resolution : 1440x900\r\nProcessor : 1.6 GHz Intel Core i5\r\nRAM : 8 GB DDR3 SDRAM\r\nHard Drive : 128 GB SSD\r\nGraphics Coprocessor : integrated_graphics\r\nChipset Brand : intel\r\nOperating System : Mac OS X\r\nProcessor Brand : Intel', 'Apple MacBook MLH82LL.png', 126342.77),
(15, 'Apple MacBook MMGL2LL/A', 'Screen Size : 12 inches\r\nScreen Resolution : 2304 x 1440\r\nMax Screen Resolution : 2304x1440 pixels\r\nProcessor : 1.1 GHz core_m\r\nRAM : 8 GB LPDDR3\r\nMemory Speed : 1866\r\nHard Drive : 256 GB Solid State Drive\r\nGraphics Coprocessor : Intel HD Graphics 515\r\nChipset Brand : intel\r\nOperating System : Mac OS X\r\nProcessor Brand : Intel', 'Apple MacBook MMGL2LL.png', 198240.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts4`
--

CREATE TABLE `cartproducts4` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts4`
--

INSERT INTO `cartproducts4` (`id`, `name`, `description`, `image`, `price`) VALUES
(16, 'Samsung Notebook 7 Spin', 'CPU: 2.5GHz Intel Core i7-6500U\r\n\r\nGraphics:Nvidia GeForce 940MX (2GB DDR3L); Intel HD Graphics 520 \r\n\r\nScreen: 15.6-inch Full HD (1,920 x 1,080) LED with touch panel \r\n\r\nStorage: 1 TB HDD â€“ 1TB HDD; 128GB SSD', 'Samsung Notebook 7 Spin.png', 182794.48),
(17, 'Samsung Notebook 9', 'CPU: 2.3GHz Intel Core i5-6200U \r\n\r\nGraphics:Intel HD Graphics 520 \r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) LED anti-reflective display \r\n\r\nStorage: 256GB', 'Samsung Notebook 9.png', 141514.57),
(18, 'Samsung Chromebook 3', 'Screen Size : 11.6 inches\r\nMax Screen Resolution : 1366x768 pixels\r\nProcessor : 2.16 GHz Intel Celeron\r\nRAM : 4 GB DDR3L SDRAM\r\nMemory Speed : 1600 MHz\r\nHard Drive : 16 GB SSD\r\nGraphics Coprocessor : Intel Graphics Integrated\r\nProcessor Brand : Intel\r\nHard Drive Rotational Speed : 1 RPM\r\nOptical Drive Type : None', 'Samsung-Chromebook-3.png', 27350.76),
(19, 'Samsung Chromebook Pro and Plus', 'Screen Size : 12.3 inches\r\nMax Screen Resolution : 2400x1600 pixels\r\nProcessor : 2 GHz None\r\nRAM : 4 GB DDR3\r\nHard Drive : 32 GB Flash Memory Solid State\r\nGraphics Coprocessor : integrated_graphics', 'Samsung-Chromebook-Pro-and-Plus.png', 83933.97),
(20, 'Samsung Ativ Book 9 (2015)', 'Screen Size : 12.2 inches\r\nMax Screen Resolution : 2500 x 1600\r\nProcessor : 0.9 GHz Intel Core 2 Quad\r\nRAM : 8 GB DDR3 SDRAM\r\nHard Drive : 256 GB SSD\r\nGraphics Coprocessor : integrated_graphics\r\nOperating System : windows, windows 10', 'Samsung-Ativ-Book-9-(2015).png', 45783.00);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts5`
--

CREATE TABLE `cartproducts5` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts5`
--

INSERT INTO `cartproducts5` (`id`, `name`, `description`, `image`, `price`) VALUES
(21, 'Lenovo Yoga 910', 'CPU: Intel Core i7 \r\n\r\nGraphics:Intel HD Graphics 620 \r\n\r\nScreen: 13.9-inch FHD 1,920 x 1,080 IPS multi-touch \r\n\r\nStorage: 512GB PCIe SSD', 'Lenovo Yoga 910.png', 182307.02),
(22, 'ThinkPad T470', 'Up to 7th Generation Intel® Core™ i7 \r\nUp to Windows 10 Pro 64 bit\r\n14\" anti-glare display, up to FHD (1920 x 1080) IPS with touch option\r\nUp to 32 GB DDR4 high-performance memory\r\nUp to 1 TB PCIe NVMe SSD or 500 GB HDD storage', 'ThinkPad-T470.png', 151083.90),
(23, 'IdeaPad Y700 (15\")', 'Up to 6th Generation Intel® Core™ i7 processor\r\nWindows 10 Home\r\nUp to 15.6\" UHD IPS AntiGlare LED Backlit (3840x2160) display (Select Models)\r\nUp to 16 GB DDR4 memory\r\nUp to 1 TB HDD with 512 GB PCIe SSD\r\nUp to NVIDIA® GeForce® GTX 960M 4 GB graphics\r\nUp to 5 hours battery life with standard battery\r\nUp to WiFi 2*2 AC + Bluetooth® 4.0', 'IdeaPad-Y700.png', 152610.00),
(24, 'Lenovo N23 Chromebook', 'Intel® Celeron dual-core processor\r\nChrome OS\r\n11.6\" HD (1366x768), 250-nit, anti-glare, 10-point multitouch display\r\nUp to 4GB LPDDR3 memory\r\nUp to 32GB eMMC storage\r\n802.11 AC 2x2 WiFi\r\nPorts: 2 USB 3.0, 2-in-1 card reader, HDMI, audio jack', 'Lenovo-N23-Chromebook.png', 135670.29),
(25, 'Yoga 910 (14\")', 'Up to 7th Gen Intel Core i7 processor\r\nWindows 10 Home/Pro\r\n13.9\" UHD IPS Multi-touch (3840x2160) with integrated camera (Select Models)\r\nUp to 16 GB memory\r\nUp to 1 TB PCIe SSD storage\r\nUp to Intel® HD graphics 620\r\n802.11 a/c 2x2 WiFi, Bluetooth® 4.1\r\nUSB 3.0 Type-C with video-out, USB 2.0 Type-C with charging, USB 3.0 with always-on charging, audio combo jack', 'Yoga-910-(14).png', 190912.06);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts6`
--

CREATE TABLE `cartproducts6` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts6`
--

INSERT INTO `cartproducts6` (`id`, `name`, `description`, `image`, `price`) VALUES
(26, 'Surface Book', 'CPU: Intel Core i5 â€“ i7 \r\n\r\nGraphics:Intel HD graphics 520 â€“ Nvidia GeForce graphics \r\n\r\nScreen: 13.5-inch, 3,000 x 2,000 PixelSense Display \r\n\r\nStorage: 128GB â€“ 256GB PCIe3.0 SSD', 'Surface Book.png', 197876.67),
(27, 'Microsoft Surface Pro 4', 'Screen Size : 12.3 inches\r\nMax Screen Resolution : 2736x1824 pixels\r\nProcessor : 2.2 GHz Core M Family\r\nRAM : 4 GB\r\nHard Drive : 128 GB Flash Memory Solid State Drive\r\nGraphics Coprocessor : Intel Integrated Graphics\r\nChipset Brand : intel\r\nOperating System : Windows 10 Pro\r\nProcessor Brand : Intel', 'Microsoft-Surface-Pro-4.png', 101981.63),
(28, 'Microsoft Surface Pro 3', 'Screen Size : 12 inches\r\nProcessor : Intel Core i7\r\nRAM : 512 GB\r\nHard Drive : 512 GB\r\nOperating System : windows_8.1_professional\r\nProcessor Brand : intel', 'Microsoft-Surface-Pro-3.png', 91405.76),
(29, 'iRULUWalknbook', '10.1” Hybrid 2-in-1 Laptop\r\n32 GB\r\nMicrosoft Windows 10\r\nDual Camera\r\nDetachable Keyboard (Orange)\r\nCPU - Intel Baytrail-T Quad-Core Processor, up to 1.83 GHz\r\nScreen – 10-point Capacitive Touchscreen\r\nResolution - 1280x800\r\nFront Camera – 2.0MP\r\nRear Camera - 5.0MP', 'iRULUWalknbook.png', 25942.17),
(30, 'Microsoft Surface 3', 'Screen Size : 10 inches\r\nScreen Resolution : 1920 x 1280\r\nProcessor : Intel Atom\r\nRAM : 4 GB\r\nHard Drive : 128 GB\r\nOperating System : Windows 10\r\nProcessor Brand : intel', 'Microsoft-Surface-3.png', 59346.98);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts7`
--

CREATE TABLE `cartproducts7` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts7`
--

INSERT INTO `cartproducts7` (`id`, `name`, `description`, `image`, `price`) VALUES
(31, 'TOSHIBA Lapatop Tecra A50-C1543', 'Intel Core i5 6th Gen 6200U (2.30 GHz)\r\n8 GB Memory 256 GB SSD\r\nIntel HD Graphics 520\r\n1366 x 768\r\nWindows 7 Professional 64-Bit (downgrade from Windows 10 Pro)\r\nDVD Super Multi', 'TOSHIBA-Laptop-Tecra-A50-C1543.png', 141622.08),
(32, 'TOSHIBA Laptop Tecra A40-C1443 Intel', 'Intel Core i5 6th Gen 6200U (2.30 GHz)\r\n8 GB Memory 256 GB SSD\r\nIntel HD Graphics 520\r\n1920 x 1080\r\nWindows 7 Professional 64-Bit (downgrade from Windows 10 Pro)\r\nDVD Super Multi', 'TOSHIBA-Laptop-Tecra-A40-C1443-Intel.png', 148030.17),
(33, 'TOSHIBA Tecra R940 - 14.0', 'Microsoft Authorized Refurbisher.\r\nGrade B Professionally Refurbished Notebook\r\nWindows 10 Pro\r\nIntel Core i5 3320M (2.60 GHz) (Ivy Bridge)\r\n14.0\" 1366 x 768\r\n4GB Memory, 250GB Hard Drive\r\nw/ Webcam Grade B', 'TOSHIBA-Tecra-R940---14.0.png', 27164.58),
(34, 'Toshiba C55DT Touchscreen Laptop ', '15.6\" touch screen for hands-on control\r\nAMD A8-6410 accelerated processor\r\n4GB system memory for basic multitasking\r\n500GB hard drive for serviceable file storage space\r\nWindows 8.1 operating system\r\nDVD RW, WiFi , Webcam, Jet Black', 'Toshiba-C55DT-Touchscreen-Laptop-.png', 67146.87),
(35, 'Toshiba KIRAbook PSU7FU-00Y00M', 'Intel Core i5\r\n3337U 1.8 GHz Dual-Core\r\n8 GB DDR3 SDRAM\r\n\r\n256 GB Solid State Drive\r\n13.3-inch Display\r\nWindows 8 64-bit Edition', 'Toshiba-KIRAbook-PSU7FU-00Y00M.png', 81641.77);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts8`
--

CREATE TABLE `cartproducts8` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts8`
--

INSERT INTO `cartproducts8` (`id`, `name`, `description`, `image`, `price`) VALUES
(36, 'Alcatel Flint', '4G LTE Unlocked Any GSM Carrier Desbloqueados GSM (Not Verizon Sprint Net10 or Any CDMA Carrier)\r\n1 Micro SIM GSM: 850/900/1800/1900MHz - UMTS: 850/1900/2100MHz - LTE: Bands 2/4/5/17\r\nQuad Core 1.1 Ghz 16Gb (10.6 Gb User) 1.5GB Ram / 8Mp Camera Flash + 2mp Rear Camera\r\nAndroid 5.1.1 5.5-inch HD (1280 x 720).', 'Alcatel Flint.png', 18311.67),
(37, 'ALCATEL OneTouch Idol 3', 'Form factor Touchscreen\r\nBattery capacity (mAh) 2610\r\nScreen size (inches) 5.20\r\nResolution : 1080x1920 pixels\r\nProcessor : 1.2GHz octa-core\r\nRAM : 3GB\r\nInternal storage : 16GB', 'ALCATEL OneTouch Idol 3.png', 22126.92),
(38, 'Alcatel Idol 4S-price', 'Operating System : Android\r\nCpu Model Speed : 1.2 GHz\r\nForm factor Touchscreen\r\nBattery capacity (mAh) : 2910\r\nScreen size (inches) : 5.50\r\nResolution : 1080x1920 pixels\r\nProcessor : 1GHz octa-core', 'Alcatel Idol 4S-price.png', 76303.47),
(39, 'Alcatel A3 XL-price', 'Form factor Touchscreen\r\nBattery capacity (mAh) : 3000\r\nScreen size (inches) : 6.00\r\nResolution : 720x1080 pixels\r\nProcessor : 1.1GHz quad-core\r\nRAM : 1GB\r\nInternal storage : 8GB\r\nRear camera : 8-megapixel', 'Alcatel A3 XL-price.png', 45781.47),
(40, 'Alcatel One Touch Pop 2', 'Form factor Touchscreen\r\nBattery capacity (mAh) : 2500\r\nScreen size (inches) : 5.00\r\nResolution : 480x854 pixels\r\nProcessor : 1.2GHz quad-core\r\nRAM : 1GB\r\nInternal storage : 8GB\r\nRear camera : 5-megapixel', 'Alcatel One Touch Pop 2.png', 106825.47);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts9`
--

CREATE TABLE `cartproducts9` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts9`
--

INSERT INTO `cartproducts9` (`id`, `name`, `description`, `image`, `price`) VALUES
(41, 'Acer Aspire S 13', 'CPU: Intel Core i3 â€“ i7 \r\n\r\nGraphics:Intel HD Graphics 520 â€“ 620 \r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) anti-glare touchscreen IPS \r\n\r\nStorage: 128GB â€“ 512GB SSD', 'Acer Aspire S 13.png', 91396.48),
(42, 'Acer Aspire E 15', 'Screen Size : 15.6 inches\r\nMax Screen Resolution : 1920 x 1080 pixels\r\nProcessor : 2.4 GHz Intel Core i3\r\nRAM : 4 GB\r\nHard Drive : 1000 GB SATA\r\nGraphics Coprocessor : Intel HD Graphics 620\r\nChipset Brand : intel', 'Acer Aspire E 15.png', 53411.97),
(43, 'Newest 2017 Acer', 'Screen Size : 15.6 inches\r\nMax Screen Resolution : 1920 x 1080\r\nProcessor : 3.1 GHz Intel Core i5\r\nRAM : 16 GB\r\nHard Drive : 1000 GB mechanical_hard_drive\r\nGraphics Coprocessor : NVIDIA GeForce', 'Newest-2017-Acer.png', 99194.97),
(44, 'Acer Aspire E5-575G-53VG', 'Screen Size : 15.6 inches\r\nScreen Resolution : 1920 x 1080 pixels\r\nMax Screen Resolution : 1920 x 1080 pixels\r\nProcessor : 2.3 GHz Intel Core i5\r\nRAM : 8 GB DDR4-SDRAM\r\nHard Drive : 256 GB SATA\r\nGraphics Coprocessor : integrated_graphics\r\nChipset Brand : NVIDIA GeForce 940MX', 'Acer Aspire E5-575G-53VG.png', 152610.00),
(50, 'Acer Aspire VX 15 Gaming Laptop', 'Screen Size : 15.6 inches\r\nMax Screen Resolution : 1920 x 1080 pixels\r\nProcessor : 2.8 GHz Intel Core i7\r\nRAM : 16 GB DDR4\r\nHard Drive : Flash Memory Solid State\r\nGraphics Coprocessor : GTX 1050 Ti\r\nChipset Brand : NVIDIA\r\nOperating System : Windows 10\r\nProcessor Brand : Intel', 'Acer Aspire VX 15 Gaming Laptop.png', 152457.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts10`
--

CREATE TABLE `cartproducts10` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts10`
--

INSERT INTO `cartproducts10` (`id`, `name`, `description`, `image`, `price`) VALUES
(51, 'OPPO NEO 7', 'Sim - Dual Sim (Nano-Sim/Micro-Sim)\r\nDisplay - Type - IPS LCD Capacitive Touchscreen, 16M Colors\r\nSize - 5.0 Inches\r\nResolution - 540 x 960 Pixels (~220 PPI Pixel Density)\r\nPlatform - OS - Android OS, v5.1 (Lollipop)\r\nMemory - Card Slot - MicroSD (Dedicated Slot), up to 256 GB\r\nInternal - 16 GB, 1 GB RAM', 'OPPO-NEO-7.png', 91564.47),
(52, 'OPPO A37', 'Sim - Dual Sim (Nano-Sim, Dual Stand-by)\r\nDisplay - Type - IPS LCD Capacitive Touchscreen, 16M Colors\r\nSize - 5.0 Inches (~67.8% screen-to-body ratio)\r\nResolution - 720 x 1280 Pixels (~294 PPI Pixel Density)\r\nPlatform - OS - Android OS, v5.1 (Lollipop)', 'OPPO-A37.png', 106674.39),
(53, 'OPPO A57', 'Processor-1.95GHz octa-core\r\nRAM 6GB\r\nInternal storage 64GB\r\nRear camera 16-megapixel\r\nOperating System Android 6.0\r\nBluetooth , v 4.00\r\nNumber of SIMs 2\r\n4G/ LTE', 'OPPO-A57.png', 121935.39),
(54, 'Oppo R9s Plus', 'Form factor-Touchscreen\r\nBattery capacity (mAh)-4000\r\nRemovable battery-No\r\nScreen size (inches)-6.00\r\nResolution-1080x1920 pixels\r\nOperating System-Android 5.1\r\nNumber of SIMs-1', 'Oppo-R9s-Plus.png', 91413.39),
(55, 'Oppo A30', 'Sim - Dual Sim (Nano-Sim, Dual Stand-by)\r\nDisplay - Type - IPS LCD Capacitive Touchscreen, 16M Colors\r\nSize - 5.2 Inches\r\nResolution - 720 x 1280 Pixels (~282 PPI Pixel Density)\r\nPlatform - OS - Android OS, v6.0 (Marshmallow)\r\nMemory - Card Slot - MicroSD, up to 256 GB (Uses Sim 2 Slot)\r\nInternal - 32 GB, 3 GB RAM\r\nCamera - Primary - 13 MP, Phase Detection Autofocus, LED Flash', 'Oppo-A30.png', 76152.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts11`
--

CREATE TABLE `cartproducts11` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts11`
--

INSERT INTO `cartproducts11` (`id`, `name`, `description`, `image`, `price`) VALUES
(56, 'iPhone 7 Plus', 'Display Size: 5.5\"\r\n\r\nResolution:1080x1920 pixels\r\n\r\nPhoto: 12MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 3GB RAM\r\n\r\nChipset: Apple A10 Fusion\r\n\r\nBattery Capacity: 2900mAh\r\n\r\nTechnology: Li-Ion', 'iPhone 7 Plus.png', 128018.13),
(57, 'Apple iPhone SE', 'Display Size: 4.0\"\r\n\r\nResolution:640x1136 pixels\r\n\r\nPhoto: 12MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 2GB RAM\r\n\r\nChipset: Apple A9\r\n\r\nBattery Capacity: 1624mAh\r\n\r\nTechnology: Li-Po\r\n', 'Apple iPhone SE.png', 80582.57),
(58, 'Apple iPhone 6S', 'Sim - Nano-SIM / Fingerprint Sensor\r\nDisplay - Type - LED-Backlit IPS LCD, Capacitive Touchscreen, 16M Colors\r\nSize - 4.7 Inches\r\nResolution - 750 x 1334 Pixels (~326 PPI Pixel Density)\r\nPlatform - OS - iOS 9\r\nInternal - 16 GB', 'Apple iPhone 6S.png', 131091.99),
(59, 'iPhone 6', '7\" Retina HD display\r\nNew 8-megapixel iSight camera with 1.5µ pixels\r\nA8 chip with 64-bit architecture\r\nSpecifications: Processor: Intel Celeron N3060 1.6GHz (Turbo up to 2.48GHz) 2MB\r\nCache Processor Core: Dual-Core Screen Size: 14\" Aspect Ratio: 16:9', 'iPhone 6-5d5a.png', 126971.52),
(60, 'Apple iPhone 5S', 'Type: LED-backlit IPS LCD\r\ncapacitive touchscreen, 16M colors\r\nSize: 4.0 inches\r\nResolution: 640 x 1136 pixels\r\nOS: iOS 7\r\nCPU: Dual-core 1.3 GHz Cyclone (ARM v8-based)\r\nGPU: PowerVR G6430 (quad-core graphics)', 'Apple iPhone 5S.png', 114304.89);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts12`
--

CREATE TABLE `cartproducts12` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts12`
--

INSERT INTO `cartproducts12` (`id`, `name`, `description`, `image`, `price`) VALUES
(61, 'HP Spectre x360 15', 'CPU: Intel Core i7 \r\n\r\nGraphics:Nvidia GeForce 940MX \r\n\r\nScreen: 15.6-inch, UHD (3,840 x 2,160) IPS UWVA-backlit multi-touch \r\n\r\nStorage: 512GB SSD\r\n', 'HP Spectre x360 15.png', 190260.17),
(62, 'HP Spectre', 'CPU: Intel Core i5 â€“ i7 \r\n\r\nGraphics: Intel HD Graphics 520 \r\n\r\nScreen: 13.3-inch FHD (1,920 x 1,080) IPS UWVA WLED \r\n\r\nStorage: 256GB â€“ 512GB SSD', 'HP Spectre.png', 91396.48),
(63, 'HP Chromebook 14', 'CPU: 1.83GHz Intel Celeron N2940 processor \r\n\r\nGraphics:Intel HD Graphics \r\n\r\nScreen: 14-inch 1,920 x 1,080 display \r\n\r\nStorage: 16GB eMMC', 'HP Chromebook 14.png', 32821.02),
(64, '2017 HP Stream', 'Screen Size : 14 inches\r\nProcessor : 1.6 GHz Intel Celeron\r\nRAM : 4 GB SDRAM\r\nHard Drive : 32 GB emmc\r\nGraphics Coprocessor : integrated_graphics\r\nChipset Brand : intel\r\nOperating System : Windows 10\r\nProcessor Brand : Intel', '2017 HP Stream.png', 28843.29),
(65, '2017 HP x2', 'Screen Size : 10.1 inches\r\nMax Screen Resolution : 1280 x 800\r\nProcessor : 1.44 GHz Intel Atom\r\nRAM : 2 GB DDR3 SDRAM\r\nHard Drive : 32 GB emmc\r\nGraphics Coprocessor : integrated_graphics\r\nCard Description : integrated\r\nOperating System : Windows 10\r\nProcessor Brand : Intel\r\nProcessor Count : 4', '2017 HP x2.png', 41052.09);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts13`
--

CREATE TABLE `cartproducts13` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts13`
--

INSERT INTO `cartproducts13` (`id`, `name`, `description`, `image`, `price`) VALUES
(66, 'Google Pixel XL', 'Display Size: 5.5\"\r\n\r\nResolution:1440x2560 pixels\r\n\r\nPhoto: 12MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 4GB RAM\r\n\r\nChipset: Snapdragon 821\r\n\r\nBattery Capacity: 3450mAh', 'Google Pixel XL.png', 365421.39),
(67, 'Google Pixel', 'Screen size-5.50inch\r\nStorage-32GB\r\nProcessor-1.6GHz quad-core\r\nRAM-4GB\r\nRear camera-12.3megapixel\r\nOS-android 7.1\r\nBattery capacity-3450mAh', 'Google Pixel.png', 117357.09),
(68, 'Google Pixel C', 'Screen cize-5.0inch\r\nStorage-32GB\r\nProcessor-1.6GHz quad-core\r\nRAM-4GB\r\nRear camera-12.3megapixel\r\nOS-android 7.1\r\nBattery capacity-2770mAh', 'Google Pixel C.png', 118883.19),
(69, 'Google Pixel 32GB', 'Screen cize-10.20inch\r\nStorage-32GB\r\nProcessor-octa-core\r\nRAM-3GB\r\nRear camera-8megapixel\r\nOS-android 6.0\r\nBattery capacity-3000mAh', 'Google Pixel 32GB.png', 91566.00),
(70, 'Google Pixel 128GB Quite Black Unlocked Fair', 'Screen cize-5.0inch\r\nStorage-32GB\r\nProcessor-1.6GHz quad-core\r\nRAM-4GB\r\nRear camera-12.3megapixel\r\nOS-android 7.1\r\nBattery capacity-2770mAh', 'Google Pixel 128GB Quite Black Unlocked Fair.png', 99043.89);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts14`
--

CREATE TABLE `cartproducts14` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts14`
--

INSERT INTO `cartproducts14` (`id`, `name`, `description`, `image`, `price`) VALUES
(71, 'OnePlus 3T', 'Display Size: 5.5\"\r\n\r\nResolution:1080x1920 pixels\r\n\r\nPhoto: 16MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 6GB RAM\r\n\r\nChipset: Snapdragon 821', 'OnePlus 3T.png', 72966.07),
(72, 'Oneplus 3', 'screen size- 5.50inch\r\nResolution-1080*1920pixels\r\nStorage-64GB\r\nRear camera-16-megapixel\r\nRAMS-6GB\r\nProcessor-1.6GHz\r\nOs-android 6.0.1\r\nBattery capacity-3000mAh', 'Oneplus-3.png', 76152.39),
(73, 'Oneplus 2', 'Screen size- 5.50inch\r\nResolution-1080*1920pixels\r\nStorage-64GB\r\nRear camera-13-megapixel\r\nRAMS-4GB\r\nProcessor-1.8GHz\r\nOs-oxygenOS 2.0\r\nBattery capacity-3300mAh', 'Oneplus-2.png', 60891.39),
(74, 'Oneplus 4', 'Screen size- 5.50inch\r\nResolution-1080*1920pixels\r\nStorage-64GB\r\nRear camera-16-megapixel\r\nRAMS-8GB\r\nProcessor-3GHz\r\nOs-oxygenOS 2.0\r\nBattery capacity-4000mAh', 'Oneplus-4.png', 106674.39),
(75, 'Oneplus one', 'Screen size- 5.46inch\r\nResolution-1080*1920pixels\r\nStorage-16GB\r\nRear camera-13-megapixel\r\nRAMS-3GB\r\nProcessor-3GHz\r\nOs-oxygenOS 2.1.4\r\nBattery capacity-4000mAh', 'Oneplus-1.png', 30369.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts15`
--

CREATE TABLE `cartproducts15` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts15`
--

INSERT INTO `cartproducts15` (`id`, `name`, `description`, `image`, `price`) VALUES
(76, 'Huawei Nexus 6P', 'Display Size: 5.7\"\r\n\r\nResolution:1440x2560 pixels\r\n\r\nPhoto: 12MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 3GB RAM\r\n\r\nChipset: Snapdragon 810', 'Huawei Nexus 6P.png', 97564.32),
(77, 'Huawei Mate 9', 'Display Size: 5.9\"\r\n\r\nResolution:1080x1920 pixels\r\n\r\nPhoto: 20MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 4GB RAM\r\n\r\nChipset: Hisilicon Kirin 960', 'Huawei Mate 9.png', 91245.67),
(78, 'Huawei P9 EVA-L09', 'OS-Android\r\nRAM-3 GB\r\nWireless communication technologies-Bluetooth, WiFi Hotspot\r\nSpecial features-Single SIM, GPS, Music Player, Video Player, Fingerprint sensor, G sensor, Gyroscope sensor, eCompass, Ambient light sensor, Proximity sensor, Hall effect sensor, E-mail\r\nOther camera features-8MP\r\nForm factor-Touchscreen Phone\r\nBattery Power Rating 3000', 'Huawei-P9-EVA-L09.png', 52650.45),
(79, 'Huawei Y541-U02', 'OS-android\r\nRAM-1 GB\r\nSpecial features-11.4CM (4.5\") LCD Screen, 8MP Main Camera & 2 MP Front camera with DUAL LED Flash, 1730 mAh Battery, Android 4.4 Kitkat, 1.2 GHz Quad Core Processor, 1GB RAM + 8GB ROM + 32GB External, Dual SIM', 'Huawei-Y541-U02.png', 22738.89),
(80, 'Huawei Honor Bee 4G', 'OS-Android\r\nForm factor-Touchscreen Phone\r\nBattery Power Rating 3000\r\nWireless communication technologies-Bluetooth, WiFi Hotspot\r\nSpecial features-Single SIM, GPS, Music Player, Video Player, Fingerprint sensor, G sensor, Gyroscope sensor, eCompass, Ambient light sensor, Proximity sensor, Hall effect sensor, E-mail', 'Huawei-Honor-Bee-4G.png', 76152.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts16`
--

CREATE TABLE `cartproducts16` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts16`
--

INSERT INTO `cartproducts16` (`id`, `name`, `description`, `image`, `price`) VALUES
(81, 'LG G5', 'Display Size: 5.3\"\r\n\r\nResolution:1440x2560 pixels\r\n\r\nPhoto: 16MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 4GB RAM\r\n\r\nChipset: Snapdragon 820', 'LG G5.png', 98862.17),
(82, 'LG G4', 'Processor-qualcomm snapdragon 808 with x10 LTE\r\nOs-android 5.1 lollipop\r\nDisplay-5.5inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-16megapixel\r\nBattery-3000mAh', 'LG-G4.png', 37999.89),
(83, 'LG G3', 'Os-android 7.0\r\nDisplay-5.7inch\r\nStorage-32GB\r\nRAM-4GB\r\nRear camera-16megapixel\r\nBattery-3300mAh', 'LG-G3.png', 19534.08),
(84, 'LG G7', 'Processor-2.46GHz\r\nOs-android 4.4.2\r\nDisplay-5.5inch\r\nStorage-16GB\r\nRAM-2GB\r\nRear camera-13megapixel\r\nBattery-3000mAh', 'LG-G7.png', 22738.89),
(85, 'LG G6', 'Processor-qualcomm snapdragon 830 SoC\r\nOs-android 5.1 lollipop\r\nDisplay-5.4inch\r\nStorage-32GB\r\nRAM-6GB\r\nRear camera-22megapixel\r\nBattery-3000mAh', 'LG-G6.png', 12056.19);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts17`
--

CREATE TABLE `cartproducts17` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts17`
--

INSERT INTO `cartproducts17` (`id`, `name`, `description`, `image`, `price`) VALUES
(86, 'HTC 10', 'Display Size: 5.2\"\r\n\r\nResolution:1440x2560 pixels\r\n\r\nPhoto: 12MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 4GB RAM\r\n\r\nChipset: Snapdragon 820', 'HTC 10.png', 106629.48),
(87, 'HTC M8', 'Processor-2.5GHz\r\nOs-android 4.4.2\r\nDisplay-5inch\r\nStorage-16GB\r\nRAM-2GB\r\nRear camera-4ultrapixel\r\nBattery-2600mAh', 'HTC M8.png', 30369.39),
(88, 'HTC M9', 'Processor-1.5GHz\r\nBattery-3000mAh\r\nOs-android 5.0\r\nDisplay-5inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-4ultrapixel', 'HTC M9.png', 106674.39),
(89, 'HTC one mini 2', 'Processor-1.2GHz\r\nOs-android 4.4\r\nDisplay-4.5inch\r\nStorage-16GB\r\nRAM-1GB\r\nRear camera-13megapixel\r\nBattery-2100mAh', 'HTC-one-mini-2.png', 118577.97),
(90, 'HTC M10', 'Processor-2.56GHz\r\nOs-android 5.0\r\nDisplay-5.5inch\r\nStorage-32GB\r\nRAM-4GB\r\nRear camera-12megapixel', 'HTC-M10.png', 121935.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts18`
--

CREATE TABLE `cartproducts18` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts18`
--

INSERT INTO `cartproducts18` (`id`, `name`, `description`, `image`, `price`) VALUES
(91, 'Sony Xperia Z5 Premium', 'Display Size: 5.5\"\r\n\r\nResolution:2160x3840 pixels\r\n\r\nPhoto: 23MP\r\n\r\nVideo: 2160p\r\n\r\nRAM: 3GB RAM', 'Sony Z5 Premium.png', 67786.85),
(92, 'Sony xperia xz', 'Processor-2.46GHz\r\nOs-android 6.0.1\r\nDisplay-5.2inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-16megapixel\r\nBattery-3000mAh', 'Sony-xperia-xz.png', 76152.39),
(93, 'Sony xperia xA', 'Processor-1.5GHz octa-core\r\nOs-android 6\r\nDisplay-5.2inch\r\nStorage-16GB\r\nRAM-2GB\r\nRear camera-13megapixel\r\nBattery-3000mAh', 'Sony-xperia-xA.png', 84698.55),
(94, 'Sony xperia x6', 'Processor-2.5GHz\r\nOs-android 7.0\r\nDisplay-5.7inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-16megapixel\r\nBattery-3300mAh', 'Sony-xperia-x6.png', 87140.31),
(95, 'Sony xperia', 'Processor-1.96GHz\r\nOs-android 4.1.2\r\nDisplay-4.3inch\r\nStorage-16GB\r\nRAM-1GB\r\nRear camera-13megapixel\r\nBattery-3000mAh', 'Sony-xperia.png', 76152.39);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts19`
--

CREATE TABLE `cartproducts19` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts19`
--

INSERT INTO `cartproducts19` (`id`, `name`, `description`, `image`, `price`) VALUES
(96, 'portable power Bank ', 'B&H # XUBUBA26B MFR # BUB-A26B\r\nTOP HIGHLIGHTS\r\nUltra Compact Design\r\n2600 mAh Battery Capacity\r\nCompatible with USB Powered Devices\r\n', 'portable power Bank.png', 699.00),
(97, 'In-Ear Headphones Headset ', 'Mini Wireless Bluetooth V4.1 Stereo Sound In - Ear Headphone with Mic for Tablet PC Smartphones  ', 'White In-Ear Headphones.png', 200.00),
(98, 'Metal Earphone handsfree Headphones', 'Although on-ear and over-ear headphones are \'in\' right now, there\'s still a place for in-ear headphones, which offer much more portability and convenience. \r\n\r\nAfter all, it\'s incredibly easy to just throw a pair of earbuds into your pocket, rather than worrying about having to wear a pair of headphones around your neck or carrying them in a bag. ', 'High Quality Stereo Headset In Ear Metal Earphone handsfree.png', 150.00),
(99, 'Wireless Bluetooth 4.0 Headset ', 'B&H # PARPTCM125K MFR # RP-TCM125-K\r\nErgoFit Design\r\nIn-Line Single Button Remote & Mic\r\niPhone, Blackberry, Palm Compatibility\r\nIncludes 3 Pairs of Earpads', 'Super Smallest Mini earphone Wireless Bluetooth 4.0 Headset Stereo.png', 3100.00),
(100, 'New Android phone charger ', 'Ports 2A USB EU Plug Charging Mobile Phone Adapter Dock Wall Charger Cell for iPhone 7 6s 6 5s 4s ipad Android Samsung Charge', 'Mivi Dual Port Car Mobile Charger with Fast Charging.png', 2500.00),
(101, '3D Back Covers ', 'silicon,plastic,leather,metal,crystal,etc', 'Samsung Galaxy J7 Prime 3D Back Covers By Renowned.png', 325.00),
(102, 'BT2046 Wireless Bluetooth Headset ', 'Jabra Sport Wireless + Bluetooth Headset \r\nIntegrated Mic for Taking Calls\r\nBuilt-In FM Radio\r\nRain, Shock, & Dust Resistant\r\n4 Hours of Talk Time', 'Jabra BT2046 Wireless Bluetooth Headset.png', 755.00),
(103, 'Dual Port Car Mobile Charger ', 'Charger over voltage protection\r\nCharger over-current protection\r\nThe charging circuit protection\r\nBatteries as the overcharge protection\r\nBatteries discharge protection\r\nThe electric core over current protection\r\n', 'Dual Port Car Mobile Charger .png', 595.00),
(104, 'Selfie Stick with Auxillary Cable ', 'Easy to use Easy to carry, adjustable Selfie stick monopod\r\nNo need to charge, no hassle of connecting through\r\nCampiatable with all smartphones & Iphone\r\nDisclaimer: Product may slightly change in photography or as per market availability but quality, pattern and purpose are fulfilled 100 percent', 'Digitek Black Selfie Stick with Auxillary Cable.png', 799.00),
(105, 'MicroSDHC Class 10 48 MB/s ', 'Capacity: Customized\r\nMemory Card Application: Cell Phone\r\nSpeed Grade: Class 10\r\nNand Flash Chips: Original and Good Die(SLC, MLC, Tlc)\r\nTrademark: Digital Legend or OEM brands', 'Samsung EVO 32GB MicroSDHC.png', 899.00);

-- --------------------------------------------------------

--
-- Table structure for table `cartproducts20`
--

CREATE TABLE `cartproducts20` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cartproducts20`
--

INSERT INTO `cartproducts20` (`id`, `name`, `description`, `image`, `price`) VALUES
(106, 'Eset smart security ', 'The two new products ESET Internet Security and ESET Smart Security Premium include many new features such as script-based attack protection, webcam protection, home network protection, password manager and secure data. Continue reading below for an overview of the new and improved features. \r\n', 'Eset smart security.png', 1850.00),
(107, 'Topre Realforce RGB keyboard ', 'The REALFORCE RGB includes high quality, double-shot sculpted keycaps to retain the premium feel, durability, and design. But what if you want more customization? REALFORCE RGB has you covered with MX stem compatibility so you can switch up your style with any 3rd party accessory keycaps.\r\n', 'Topre Realforce RGB keyboard.png', 36527.00),
(108, 'Logitech MX Anywhere Mouse ', 'Darkfield laser tracking gives you flawless control on virtually any surface, including glass and high-gloss surfaces.\r\nThis wireless travel mouse performs anywhere you need it to-glass tables in your hotel room, shiny laminate tops, train and airplane tray tables, and even your jeans. Unlike traditional laser and optical mice which use irregularities on the surface to track mouse movements, Darkfield technology uses the smallest possible detail to create a micro-road map of the surface.\r\nIn tests, the mouse performed best on glass with a minimum thickness of 4mm.\r\n', 'Logitech MX Anywhere Mouse.png', 4489.00),
(109, 'Google Jam Board ', 'Google Jam Board', 'Google Jam Board.png', 13129.00),
(110, 'Hard Disk', 'Specifications \r\nModel Number ST3500630AS\r\nInterface SATA 3Gb/s\r\nCache 16MB\r\nCapacity 500GB\r\nGuaranteed Sectors 976,773,168', 'Hard Disk.png', 35110.00),
(111, 'Video graphic Array (VGA)', 'Specifications \r\nModel Number ST3500630AS\r\nInterface SATA 3Gb/s\r\nCache 16MB\r\nCapacity 500GB\r\nGuaranteed Sectors 976,773,168', 'vga.png', 35800.00),
(112, 'wireless N USB ADSL2 + Modem Router ', '\r\nGigabit FTTH Router ONU WiFi Router with IPTV/VoIP/CATV/WiFi Onaccess 454wr', 'TP link wireless N USB ADSL2 + Modem Router.png', 5150.00),
(113, 'Logitech HDwebcam C170', 'Connect with everyone in Full HD 1080p on Skype, or in fluid HD 720p on FaceTime for Mac.\r\nAlso make high-quality video calls with Google Hangouts and video-calling clients. \r\nEven chat with your Facebook friends with video calling powered by Skype or Facebook Messenger.\r\n', 'Logitech HDwebcam C170.png', 2400.00),
(114, 'EPSON M100 Printer ', 'Epson\'s fast-drying genuine pigment ink ensures business documents are water, smudge and fade resistant, while Micro Piezo technology offers Epson-quality document printing. In addition, a 12-month (or 50,000-page) warranty, and additional service support, provide peace of mind and help if you need it.', 'EPSON M100 Printer.png', 26700.00);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `CategoryID` varchar(10) NOT NULL,
  `CategoryName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`CategoryID`, `CategoryName`) VALUES
('C00001', 'Laptops and Notebooks'),
('C00002', 'Smart Phones'),
('C00003', 'Computer Accessories'),
('C00004', 'Mobile Accessories');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CustomerID` varchar(10) NOT NULL,
  `C_fname` varchar(30) NOT NULL,
  `C_lname` varchar(30) NOT NULL,
  `C_email` varchar(30) NOT NULL,
  `C_ContactNo` int(10) NOT NULL,
  `C_City` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`CustomerID`, `C_fname`, `C_lname`, `C_email`, `C_ContactNo`, `C_City`) VALUES
('CID00001', 'Amal', 'Perera', 'amal.p@gmail.com', 754213690, 'Kandy'),
('CID00002', 'Amali', 'Gunasingha', 'amali21@gmail.com', 781234564, 'Ambalangoda'),
('CID00003', 'Sumali', 'Amarasingha', 'sumali23@gmail.com', 745969990, 'Bandarawela'),
('CID00004', 'Maheshi', 'Amarasingha', 'amarasingha33@gmail.com', 754218892, 'Malabe'),
('CID00005', 'Deepa', 'Samarasingha', 'deepa21@gmail.com', 774561238, 'Embilipitiya'),
('CID00006', 'Amal', 'Gunasingha', 'Amal11@gmail.com', 745698523, 'Ambalangoda'),
('CID00007', 'Nuwan', 'Gunawardana', 'nuwan43@gmail.com', 756987422, 'Hambanthota'),
('CID00008', 'Sanduni', 'Amarasinghe', 'samarasinghe@gmail.com', 789654412, 'Kandy'),
('CID00009', 'Chathurika', 'Weerasekara', 'chathu@gmail.com', 756983645, 'Badulla'),
('CID00010', 'Bawani', 'Weerathunga', 'bawani23@gmail.com', 786395462, 'Colombo'),
('CID00011', 'Dasun', 'Gunasinghe', 'dasung@gmail.com', 799856321, 'Malabe'),
('CID00012', 'Kasuni', 'Bamunugama', 'kasuni12@gmail.com', 745698996, 'Kaduwela'),
('CID00013', 'Isuru', 'Weerakoon', 'isuruk@gmail.com', 786954321, 'Homagama'),
('CID00014', 'Ishani', 'Disanayake', 'ishani@gmail.com', 785698321, 'Bandarawela'),
('CID00015', 'Madushanika', 'Kumanayake', 'kmadu3@gmail.com', 723689745, 'Embilitiya');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `CustomerID` varchar(10) NOT NULL,
  `OrderID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`CustomerID`, `OrderID`, `ProductID`) VALUES
('CID00003', 'ORD00001', 'P00028'),
('CID00007', 'ORD00002', 'P00002'),
('CID00005', 'ORD00003', 'P00032'),
('CID00013', 'ORD00004', 'P00011'),
('CID00002', 'ORD00005', 'P00005');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ProductID` varchar(10) NOT NULL,
  `CategoryID` varchar(10) NOT NULL,
  `CompanyID` varchar(10) NOT NULL,
  `ProductName` varchar(300) NOT NULL,
  `ProductDescription` varchar(3000) NOT NULL,
  `UnitPrice` float NOT NULL,
  `UnitsInStock` int(10) NOT NULL,
  `QuantityPerUnit` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ProductID`, `CategoryID`, `CompanyID`, `ProductName`, `ProductDescription`, `UnitPrice`, `UnitsInStock`, `QuantityPerUnit`) VALUES
('P00001', 'C00001', 'S00001', 'Dell XPS 13', 'CPU: Intel Core i3 – i7\r\n\r\n\r\nGraphics: Intel HD Graphics 620 \r\n\r\n\r\nScreen: 13.3-inch FHD (1,920 x 1,080) – QHD+ (3,200 x 1,800) \r\n\r\n\r\nStorage: 128GB – 512GB SSD\r\n', 98862.2, 10, 3),
('P00002', 'C00001', 'S00002', 'Asus ZenBook UX305', 'CPU: Intel Core Intel Core M3-6Y30 – M7-6Y75 \r\n\r\n\r\nGraphics: Intel HD Graphics 515 \r\n\r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) – QHD+ (3200 x 1800) IPS display \r\n\r\n\r\nStorage: 256GB – 512GB SSD\r\n', 98862.2, 10, 3),
('P00003', 'C00001', 'S00003', 'Razer Blade Stealth', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:Intel HD Graphics 620 \r\n\r\n\r\nScreen:  12.5-inch, QHD+ (2,560 x 1,440) – 4K (3,840 x 2,160) IGZO LED-backlit multi-touch \r\n\r\n\r\nStorage: 128GB – 1TB SSD\r\n', 152178, 10, 3),
('P00004', 'C00001', 'S00002', 'Asus Chromebook Flip ', 'CPU:  Intel Pentium – Core m3 \r\n\r\n\r\nGraphics:Intel HD Graphics 515 \r\n\r\n\r\nScreen: 12.5-inch, FHD (1,920 x 1,080) LED backlit anti-glare \r\n\r\n\r\nStorage: 32GB – 64GB eMMC\r\n', 76012.7, 10, 3),
('P00005', 'C00001', 'S00004', 'Samsung Notebook 7 Spin', 'CPU:  2.5GHz Intel Core i7-6500U\r\n\r\n\r\nGraphics:Nvidia GeForce 940MX (2GB DDR3L); Intel HD Graphics 520 \r\n\r\n\r\nScreen: 15.6-inch Full HD (1,920 x 1,080) LED with touch panel \r\n\r\n\r\nStorage: 1 TB HDD – 1TB HDD; 128GB SSD\r\n', 182794, 10, 3),
('P00006', 'C00001', 'S00005', 'Acer Aspire S 13', 'CPU:  Intel Core i3 – i7 \r\n\r\n\r\nGraphics:Intel HD Graphics 520 – 620 \r\n\r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) anti-glare touchscreen IPS \r\n\r\n\r\nStorage: 128GB – 512GB SSD\r\n', 91396.5, 10, 3),
('P00007', 'C00001', 'S00004', 'Samsung Notebook 9', 'Samsung Notebook 9', 141515, 10, 3),
('P00008', 'C00001', 'S00006', 'Surface Book', 'CPU:  Intel Core i5 – i7 \r\n\r\n\r\nGraphics:Intel HD graphics 520 – Nvidia GeForce graphics \r\n\r\n\r\nScreen: 13.5-inch, 3,000 x 2,000 PixelSense Display \r\n\r\n\r\nStorage: 128GB – 256GB PCIe3.0 SSD\r\n', 197877, 10, 3),
('P00009', 'C00001', 'S00007', 'HP Spectre x360 15', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:Nvidia GeForce 940MX \r\n\r\n\r\nScreen: 15.6-inch, UHD (3,840 x 2,160) IPS UWVA-backlit multi-touch \r\n\r\n\r\nStorage: 512GB SSD\r\n', 190260, 10, 3),
('P00010', 'C00001', 'S00006', '  MacBook', 'CPU:  Intel Core m3 – m5 \r\n\r\n\r\nGraphics:Intel HD Graphics 515 \r\n\r\n\r\nScreen: 12-inch, 2304 x 1,440 LED-backlit IPS display \r\n\r\n\r\nStorage: 256GB – 512GB SSD\r\n', 231389, 10, 3),
('P00011', 'C00001', 'S00002', '  Asus ZenBook Flip UX360', 'CPU:  Intel Core m3 – Core m7 \r\n\r\n\r\nGraphics: Intel HD Graphics 515 \r\n\r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) LED-backlit glare touchscreen \r\n\r\n\r\nStorage: 128GB – 512GB SSD\r\n', 84695.5, 10, 3),
('P00012', 'C00001', 'S00007', '  HP Spectre', 'CPU:  Intel Core i5 – i7 \r\n\r\n\r\nGraphics: Intel HD Graphics 520 \r\n\r\n\r\nScreen: 13.3-inch FHD (1,920 x 1,080) IPS UWVA WLED \r\n\r\n\r\nStorage: 256GB – 512GB SSD\r\n', 91396.5, 10, 3),
('P00013', 'C00001', 'S00008', '  MacBook Pro', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:AMD Radeon Pro 450 – 460 \r\n\r\n\r\nScreen: 15.4-inch Retina (2,880 x 1,800) LED-backlit IPS \r\n\r\n\r\nStorage: 256GB – 2TB PCIe SSD\r\n', 342590, 10, 3),
('P00014', 'C00001', 'S00009', 'Lenovo Yoga 910', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:Intel HD Graphics 620 \r\n\r\n\r\nScreen: 13.9-inch FHD 1,920 x 1,080 IPS multi-touch \r\n\r\n\r\nStorage: 512GB PCIe SSD\r\n', 182307, 10, 3),
('P00015', 'C00001', 'S00007', '  HP Chromebook 14', 'CPU:  1.83GHz Intel Celeron N2940 processor \r\n\r\n\r\nGraphics:Intel HD Graphics \r\n\r\n\r\nScreen: 14-inch 1,920 x 1,080 display \r\n\r\n\r\nStorage: 16GB eMMC\r\n', 32821, 10, 3),
('P00016', 'C00002', 'S00008', 'iPhone 7 Plus', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1080x1920 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Apple A10 Fusion\r\n\r\n\r\nBattery Capacity: 2900mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 128018, 10, 3),
('P00017', 'C00002', 'S00004', 'Samsung Galaxy S7 edge', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 820\r\n\r\n\r\nBattery Capacity: 3600mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 83778.5, 10, 4),
('P00018', 'C00002', 'S00011', 'Google Pixel XL', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 821\r\n\r\n\r\nBattery Capacity: 3450mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 365421, 10, 3),
('P00019', 'C00002', 'S00008', 'Apple iPhone SE', 'Display Size: 4.0\"\r\n\r\n\r\nResolution:640x1136 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 2GB RAM\r\n\r\n\r\nChipset: Apple A9\r\n\r\n\r\nBattery Capacity: 1624mAh\r\n\r\n\r\nTechnology: Li-Po\r\n', 80582.6, 10, 3),
('P00020', 'C00002', 'S00012', 'OnePlus 3T', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1080x1920 pixels\r\n\r\n\r\nPhoto: 16MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 6GB RAM\r\n\r\n\r\nChipset: Snapdragon 821\r\n\r\n\r\nBattery Capacity: 3400mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 72966.1, 10, 4),
('P00021', 'C00002', 'S00013', 'Huawei Nexus 6P', 'Display Size: 5.7\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Snapdragon 810\r\n\r\n\r\nBattery Capacity: 3450mAh\r\n\r\n\r\nTechnology: Li-Po\r\n', 97564.3, 10, 3),
('P00022', 'C00002', 'S00014', 'LG G5', 'Display Size: 5.3\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 16MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 820\r\n\r\n\r\nBattery Capacity: 2800mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 98862.2, 10, 4),
('P00023', 'C00002', 'S00015', 'HTC 10', 'Display Size: 5.2\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 820\r\n\r\n\r\nBattery Capacity: 3000mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 106629, 10, 3),
('P00024', 'C00002', 'S00013', 'Huawei Mate 9', 'Display Size: 5.9\"\r\n\r\n\r\nResolution:1080x1920 pixels\r\n\r\n\r\nPhoto: 20MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Hisilicon Kirin 960\r\n\r\n\r\nBattery Capacity: 4000mAh\r\n\r\n\r\nTechnology: Li-Po\r\n', 91245.7, 10, 3),
('P00025', 'C00002', 'S00016', 'Sony Xperia Z5 Premium', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:2160x3840 pixels\r\n\r\n\r\nPhoto: 23MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Snapdragon 810\r\n\r\n\r\nBattery Capacity: 3430mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 67786.9, 10, 3),
('P00026', 'C00002', 'S00017', 'Motorola Moto X Force', 'Display Size: 5.4\"\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 21MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Snapdragon 810\r\n\r\n\r\nBattery Capacity: 3760mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 45697.5, 10, 3),
('P00027', 'C00003', 'S00021', '  Eset smart security ', 'The two new products ESET Internet Security and ESET Smart Security Premium include many new features such as script-based attack protection, webcam protection, home network protection, password manager and secure data. Continue reading below for an overview of the new and improved features. \r\n', 1850, 10, 3),
('P00028', 'C00003', 'S00021', 'Topre Realforce RGB– keyboard ', 'The REALFORCE RGB includes high quality, double-shot sculpted keycaps to retain the premium feel, durability, and design. But what if you want more customization? REALFORCE RGB has you covered with MX stem compatibility so you can switch up your style with any 3rd party accessory keycaps.\r\n', 36.527, 10, 3),
('P00029', 'C00003', 'S00021', '  Logitech MX Anywhere– Mouse ', 'Darkfield™ laser tracking gives you flawless control on virtually any surface, including glass and high-gloss surfaces.\r\nThis wireless travel mouse performs anywhere you need it to—glass tables in your hotel room, shiny laminate tops, train and airplane tray tables, and even your jeans. Unlike traditional laser and optical mice which use irregularities on the surface to track mouse movements, Darkfield technology uses the smallest possible detail to create a micro-road map of the surface.\r\nIn tests, the mouse performed best on glass with a minimum thickness of 4mm.\r\n', 4489.55, 10, 3),
('P00030', 'C00003', 'S00021', 'Google Jam Board', 'The newest addition to G Suite, Jamboard merges the worlds of physical and digital creativity. It’s real time collaboration on a brilliant scale, whether your team is together in the conference room or spread all over the world.\r\n', 913, 10, 3),
('P00031', 'C00003', 'S00021', 'Hard Disk', 'Specifications \r\nModel Number ST3500630AS\r\nInterface SATA 3Gb/s\r\nCache 16MB\r\nCapacity 500GB\r\nGuaranteed Sectors 976,773,168', 35800, 10, 3),
('P00032', 'C00003', 'S00021', 'Video graphic Array (VGA)', 'Specifications \r\nModel Number ST3500630AS\r\nInterface SATA 3Gb/s\r\nCache 16MB\r\nCapacity 500GB\r\nGuaranteed Sectors 976,773,168', 35800, 10, 3),
('P00033', 'C00003', 'S00021', ' wireless Router ', '\r\nGigabit FTTH Router ONU WiFi Router with IPTV/VoIP/CATV/WiFi Onaccess 454wr', 5750, 10, 3),
('P00034', 'C00003', 'S00021', '  Logitech HDwebcam C170', 'Connect with everyone in Full HD 1080p on Skype, or in fluid HD 720p on FaceTime for Mac.Also make high-quality video calls with Google Hangouts™ and video-calling clients. Even chat with your Facebook® friends with video calling powered by Skype or Facebook Messenger.\r\n', 2400, 10, 3),
('P00035', 'C00003', 'S00021', '  EPSON M100 Printer', 'Epson\'s fast-drying genuine pigment ink ensures business documents are water, smudge and fade resistant, while Micro Piezo technology offers Epson-quality document printing. In addition, a 12-month (or 50,000-page) warranty, and additional service support, provide peace of mind and help if you need it.', 26, 10, 3),
('P00036', 'C00004', 'S00022', 'Portable Power Bank  ', 'B&H # XUBUBA26B MFR # BUB-A26B\r\nTOP HIGHLIGHTS\r\nUltra Compact Design\r\n2600 mAh Battery Capacity\r\nCompatible with USB Powered Devices\r\n', 699, 10, 3),
('P00037', 'C00004', 'S00022', 'Earphones for Samsung Phone ', 'Mini Wireless Bluetooth V4.1 Stereo Sound In - Ear Headphone with Mic for Tablet PC Smartphones  ', 200, 10, 3),
('P00038', 'C00004', 'S00022', ' Earbuds for Samsung ', 'Although on-ear and over-ear headphones are \'in\' right now, there\'s still a place for in-ear headphones, which offer much more portability and convenience. \r\n\r\nAfter all, it\'s incredibly easy to just throw a pair of earbuds into your pocket, rather than worrying about having to wear a pair of headphones around your neck or carrying them in a bag. ', 150, 10, 3),
('P00039', 'C00004', 'S00022', 'Mini earphone Wireless ', 'B&H # PARPTCM125K MFR # RP-TCM125-K\r\nErgoFit Design\r\nIn-Line Single Button Remote & Mic\r\niPhone, Blackberry, Palm Compatibility\r\nIncludes 3 Pairs of Earpads', 3100, 10, 3),
('P00040', 'C00004', 'S00022', 'New Android phone charger ', 'Ports 2A USB EU Plug Charging Mobile Phone Adapter Dock Wall Charger Cell for iPhone 7 6s 6 5s 4s ipad Android Samsung Charge', 2500, 10, 3),
('P00041', 'C00004', 'S00022', 'Samsung 3D Back Covers ', 'silicon,plastic,leather,metal,crystal,etc', 325, 10, 3),
('P00042', 'C00004', 'S00022', 'Jabra WirelessBluetoothHeadset', 'Jabra Sport Wireless + Bluetooth Headset \r\nIntegrated Mic for Taking Calls\r\nBuilt-In FM Radio\r\nRain, Shock, & Dust Resistant\r\n4 Hours of Talk Time', 755, 10, 3),
('P00043', 'C00004', 'S00022', ' Mobile Charger', 'Charger over voltage protection\r\nCharger over-current protection\r\nThe charging circuit protection\r\nBatteries as the overcharge protection\r\nBatteries discharge protection\r\nThe electric core over current protection\r\n', 595, 10, 3),
('P00044', 'C00004', 'S00022', 'Selfie Stick &Auxillary Cable ', 'Easy to use Easy to carry, adjustable Selfie stick monopod\r\nNo need to charge, no hassle of connecting through\r\nCampiatable with all smartphones & Iphone\r\nDisclaimer: Product may slightly change in photography or as per market availability but quality, pattern and purpose are fulfilled 100 percent', 799, 10, 3),
('P00045', 'C00004', 'S00022', 'Samsung 32GB MicroSDHC', 'Capacity: Customized\r\nMemory Card Application: Cell Phone\r\nSpeed Grade: Class 10\r\nNand Flash Chips: Original and Good Die(SLC, MLC, Tlc)\r\nTrademark: Digital Legend or OEM brands', 899, 10, 3);

-- --------------------------------------------------------

--
-- Table structure for table `searchproduct`
--

CREATE TABLE `searchproduct` (
  `ProductID` varchar(10) NOT NULL,
  `CategoryID` varchar(10) NOT NULL,
  `CompanyID` varchar(10) NOT NULL,
  `brand` varchar(255) NOT NULL,
  `ProductName` varchar(300) NOT NULL,
  `ProductDescription` varchar(3000) NOT NULL,
  `image` varchar(255) NOT NULL,
  `UnitPrice` double(10,2) NOT NULL,
  `UnitsInStock` int(10) NOT NULL,
  `QuantityPerUnit` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `searchproduct`
--

INSERT INTO `searchproduct` (`ProductID`, `CategoryID`, `CompanyID`, `brand`, `ProductName`, `ProductDescription`, `image`, `UnitPrice`, `UnitsInStock`, `QuantityPerUnit`) VALUES
('P00001', 'C00001', 'S00002', 'Dell', 'Dell XPS 13', 'CPU: Intel Core i3-i7\r\n\r\n\r\nGraphics: Intel HD Graphics 620 \r\n\r\n\r\nScreen: 13.3-inch FHD (1,920 x 1,080)- QHD+ (3,200 x 1,800) \r\n\r\n\r\nStorage: 128GB-512GB SSD\r\n', 'Dell XPS 13.png', 98862.20, 10, 5),
('P00002', 'C00001', 'S00002', 'Asus', 'Asus ZenBook UX305', 'CPU: Intel Core Intel Core M3-6Y30-M7-6Y75 \r\n\r\n\r\nGraphics: Intel HD Graphics 515 \r\n\r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080)-QHD+ (3200 x 1800) IPS display \r\n\r\n\r\nStorage: 256GB-512GB SSD', 'Asus ZenBook UX305.png', 98862.20, 10, 5),
('P00003', 'C00001', 'S00003', 'Razer', 'Razer Blade Stealth', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:Intel HD Graphics 620 \r\n\r\n\r\nScreen:  12.5-inch, QHD+ (2,560 x 1,440)- 4K (3,840 x 2,160) IGZO LED-backlit multi-touch \r\n\r\n\r\nStorage: 128GB-1TB SSD\r\n', 'Razer Blade Stealth.png', 152178.00, 10, 5),
('P00004', 'C00001', 'S00002', 'Asus', 'Asus Chromebook Flip ', 'CPU:  Intel Pentium - Core m3 \r\n\r\n\r\nGraphics:Intel HD Graphics 515 \r\n\r\n\r\nScreen: 12.5-inch, FHD (1,920 x 1,080) LED backlit anti-glare \r\n\r\n\r\nStorage: 32GB- 64GB eMMC\r\n', 'Asus Chromebook Flip .png', 76012.70, 10, 5),
('P00005', 'C00001', 'S00004', 'Samsung', 'Samsung Notebook 7 Spin', 'CPU:  2.5GHz Intel Core i7-6500U\r\n\r\n\r\nGraphics:Nvidia GeForce 940MX (2GB DDR3L); Intel HD Graphics 520 \r\n\r\n\r\nScreen: 15.6-inch Full HD (1,920 x 1,080) LED with touch panel \r\n\r\n\r\nStorage: 1 TB HDD-1TB HDD; 128GB SSD\r\n\r\n', 'Samsung Notebook 7 Spin.png', 182794.00, 10, 5),
('P00006', 'C00001', 'S00005', 'Acer', 'Acer Aspire S 13', 'CPU:  Intel Core i3-i7 \r\n\r\n\r\nGraphics:Intel HD Graphics 520-620 \r\n\r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) anti-glare touchscreen IPS \r\n\r\n\r\nStorage: 128GB-512GB SSD', 'Acer Aspire S 13.png', 91396.50, 10, 5),
('P00007', 'C00001', 'S00004', 'Samsung', 'Samsung Notebook 9', 'Samsung Notebook 9', 'Samsung Notebook 9.png', 141515.00, 10, 5),
('P00008', 'C00001', 'S00006', 'Microsoft', 'Surface Book', 'CPU:  Intel Core i5-i7 \r\n\r\n\r\nGraphics:Intel HD graphics 520-Nvidia GeForce graphics \r\n\r\n\r\nScreen: 13.5-inch, 3,000 x 2,000 PixelSense Display \r\n\r\n\r\nStorage: 128GB-256GB PCIe3.0 SSD\r\n', 'Surface Book.png', 197877.00, 10, 5),
('P00009', 'C00001', 'S00007', 'HP', 'HP Spectre x360 15', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:Nvidia GeForce 940MX \r\n\r\n\r\nScreen: 15.6-inch, UHD (3,840 x 2,160) IPS UWVA-backlit multi-touch \r\n\r\n\r\nStorage: 512GB SSD\r\n', 'HP Spectre x360 15.png', 190260.00, 10, 5),
('P00010', 'C00001', 'S00006', 'Apple', '  MacBook', 'CPU:  Intel Core m3-m5 \r\n\r\n\r\nGraphics:Intel HD Graphics 515 \r\n\r\n\r\nScreen: 12-inch, 2304 x 1,440 LED-backlit IPS display \r\n\r\n\r\nStorage: 256GB-512GB SSD\r\n', 'MacBook.png', 231389.00, 10, 5),
('P00011', 'C00001', 'S00002', 'Asus', '  Asus ZenBook Flip UX360', 'CPU:  Intel Core m3-Core m7 \r\n\r\n\r\nGraphics: Intel HD Graphics 515 \r\n\r\n\r\nScreen: 13.3-inch, FHD (1,920 x 1,080) LED-backlit glare touchscreen \r\n\r\n\r\nStorage: 128GB-512GB SSD\r\n', 'Asus ZenBook Flip UX360.png', 84695.50, 10, 5),
('P00012', 'C00001', 'S00007', 'HP', '  HP Spectre', 'CPU:  Intel Core i5-i7 \r\n\r\n\r\nGraphics: Intel HD Graphics 520 \r\n\r\n\r\nScreen: 13.3-inch FHD (1,920 x 1,080) IPS UWVA WLED \r\n\r\n\r\nStorage: 256GB-512GB SSD\r\n\r\n', 'HP Spectre.png', 91396.50, 10, 5),
('P00013', 'C00001', 'S00008', 'Apple', '  MacBook Pro', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:AMD Radeon Pro 450-460 \r\n\r\n\r\nScreen: 15.4-inch Retina (2,880 x 1,800) LED-backlit IPS \r\n\r\n\r\nStorage: 256GB-2TB PCIe SSD\r\n', 'MacBook-Pro-(15-inch,-Late-2016).png', 342590.00, 10, 5),
('P00014', 'C00001', 'S00009', 'Lenovo', 'Lenovo Yoga 910', 'CPU:  Intel Core i7 \r\n\r\n\r\nGraphics:Intel HD Graphics 620 \r\n\r\n\r\nScreen: 13.9-inch FHD 1,920 x 1,080 IPS multi-touch \r\n\r\n\r\nStorage: 512GB PCIe SSD\r\n', 'Lenovo Yoga 910.png', 182307.00, 10, 5),
('P00015', 'C00001', 'S00007', 'HP', '  HP Chromebook 14', 'CPU:  1.83GHz Intel Celeron N2940 processor \r\n\r\n\r\nGraphics:Intel HD Graphics \r\n\r\n\r\nScreen: 14-inch 1,920 x 1,080 display \r\n\r\n\r\nStorage: 16GB eMMC\r\n', 'HP Chromebook 14.png', 32821.00, 10, 5),
('P00016', 'C00001', 'S00010', 'Toshiba', 'TOSHIBA Laptop Tetra A50-C1543 \r\n\r\n', 'Intel Core i5 6th Gen 6200U (2.30 GHz)\r\n8 GB Memory 256 GB SSD\r\nIntel HD Graphics 520\r\n1366 x 768\r\nWindows 7 Professional 64-Bit (downgrade from Windows 10 Pro)\r\nDVD Super Multi\r\n', 'TOSHIBA-Laptop-Tecra-A50-C1543.png', 141622.08, 10, 5),
('P00017', 'C00001', 'S00010', 'Toshiba', 'TOSHIBA Laptop Tetra A40-C1443 Intel ', 'Intel Core i5 6th Gen 6200U (2.30 GHz)\r\n8 GB Memory 256 GB SSD\r\nIntel HD Graphics 520\r\n\r\n1920 x 1080\r\nWindows 7 Professional 64-Bit (downgrade from Windows 10 Pro)\r\n', 'TOSHIBA-Laptop-Tecra-A40-C1443-Intel.png', 148030.17, 10, 5),
('P00018', 'C00001', 'S00010', 'Toshiba', 'TOSHIBA Tetra R940 - 14.0', 'Microsoft Authorized Refurbisher.\r\nGrade B Professionally Refurbished Notebook\r\nWindows 10 Pro\r\nIntel Core i5 3320M (2.60 GHz) (Ivy Bridge)\r\n14.0\" 1366 x 768\r\n4GB Memory, 250GB Hard Drive\r\n', 'TOSHIBA-Tecra-R940---14.0.png', 27164.58, 10, 5),
('P00019', 'C00001', 'S00010', 'Toshiba', 'Toshiba C55DT Touchscreen Laptop v', '15.6\" touch screen for hands-on control\r\nAMD A8-6410 accelerated processor\r\n4GB system memory for basic multitasking\r\n500GB hard drive for serviceable file storage space\r\nWindows 8.1 operating system\r\n', 'Toshiba-C55DT-Touchscreen-Laptop-.png', 67146.87, 10, 5),
('P00020', 'C00001', 'S00010', 'Toshiba', '\r\nToshiba KIRA book PSU7FU-00Y00M \r\n', 'CPU - intel Core i7-7600U\r\nOperating System- Windows 10 Pro\r\nRAM-16GB\r\nHard Drive Size-256GB\r\nDisplay Size-256GB\r\nGraphics Card- Intel HD 620 Graphics\r\nTouchpad Size-3.9 x 2.1 inches\r\n', 'Toshiba-KIRAbook-PSU7FU-00Y00M.png', 81641.77, 10, 5),
('P00021', 'C00001', 'S00002', 'Dell', 'Dell Latitude ', 'Dell Latitude 5280 Review\r\nCPU - intel Core i7-7600U\r\nOperating System- Windows 10 Pro\r\nRAM-16GB\r\nHard Drive Size-256GB\r\nDisplay Size-256GB\r\nGraphics Card- Intel HD 620 Graphics\r\nTouchpad Size-3.9 x 2.1 inches\r\n', 'Dell Latitude.png', 129565.89, 10, 5),
('P00022', 'C00001', 'S00002', 'Dell', 'Dell Precision 3520 ', 'CPU-2.9-GHz Intel Core i7-7820HQ CPU\r\nOperating System- Windows 10 Pro\r\nRAM-32GB\r\nHard Drive Size-512GB SSD\r\nDisplay Size-15.6\r\nGraphics Card- Nvidia Quadro M620 2GB / Intel HD Graphics 630\r\nTouchpad Size-4 x 2 inches\r\n', 'Dell Precision.png', 152457.39, 10, 5),
('P00023', 'C00001', 'S00002', 'Dell', 'Dell Inspiron 13 7000 (2017) Review', 'CPU-2.5 GHz Intel Core i5-7200U\r\nOperating System- Windows 10 Home\r\nRAM-16GB\r\nHard Drive Size-256GB SSD\r\nDisplay Size-13.3\r\nGraphics Card- Intel HD Graphics 620\r\nTouchpad Size-4.5 x 2.6 inches\r\n', 'Dell Inspiron.png', 106825.47, 10, 5),
('P00024', 'C00001', 'S00002', 'Dell', 'Dell Inspiron 17 7000 2-in-1 Review', 'CPU-2.7-GHz Intel Core i7-7500U CPU\r\nOperating System- Windows 10 Home\r\nRAM-16GB\r\nHard Drive Size-1 TB\r\nDisplay Size-17.3\r\nGraphics Card- NVIDIA GeForce GTX 940MX 2GB GDDR5 / Intel HD Graphics 620\r\nVideo Memory-2GB\r\nBluetooth- Bluetooth 4.2\r\nTouchpad Size-4.1 x 3.2\r\n', 'Dell Inspiron 17 7000 2-in-1.png', 137347.47, 10, 5),
('P00025', 'C00001', 'S00002', 'Asus', 'Asus - Q524UQ 2-in-1 ', 'Screen size-15.6\" Touch-Screen Laptop\r\nIntel Core i7 \r\n12GB Memory\r\nNVIDIA GeForce 940MX \r\n2TB Hard Drive\r\nSandblasted black aluminum with gunmetal hinge\r\n\r\n', 'Asus Q524UQ in1 15.6Touch-Screen Laptop.png', 152608.47, 10, 4),
('P00026', 'C00001', 'S00002', 'Asus', 'Asus - Q504UA 2-in-1\r\n', 'Screen size- 15.6\" Touch-Screen Laptop\r\n - Intel Core i5\r\n - 12GB Memory\r\n - 1TB Hard Drive \r\n- Sandblasted aluminum silver with chrome hinge\r\n', 'Asus  Touch-Screen Laptop.png', 152610.00, 10, 5),
('P00027', 'C00001', 'S00003', 'Razer', 'Razer-Blade', '14\" Laptop \r\n- Intel Core i7\r\n - 16GB Memory\r\n - NVIDIA GeForce GTX 1060\r\n - 256GB Solid State Drive\r\n', 'Razer-Blade.png', 98990.00, 10, 5),
('P00028', 'C00001', 'S00003', 'Razer', 'Razer - Blade Pro ', '1TB SSD\r\n\r\n 32GB of RAM \r\n Intel Core i7 processor\r\n 17.3-inch multi-touch screen \r\n', 'Razer - Blade Pro .png', 120599.00, 10, 5),
('P00029', 'C00001', 'S00003', 'Razer', 'Razer - Blade 14\" Laptop ', 'Intel Core i7 \r\n16GB Memory  \r\n1060 - 512GB Solid State Drive\r\n', 'Razer - Blade 14Laptop .png', 115699.00, 10, 5),
('P00030', 'C00001', 'S00003', 'Razer', 'Razer - Blade Pro -32', '32GB of RAM \r\nIntel Core i7 processor\r\n 17.3-inch multi-touch screen \r\n 1TB drive to store large \r\n', 'Razer - Blade Pro -32.png', 175000.00, 10, 5),
('P00031', 'C00001', 'S00004', 'Samsung', 'Samsung Chromebook 3 ', 'Screen Size-11.6 inches\r\nProcessor-2.16 GHz Intel Celeron\r\nRAM-4 GB DDR3L SDRAM\r\nMemory Speed-1600 MHz\r\nHard Drive-16 GB SSD\r\nGraphics Coprocessor- Intel Graphics Integrated\r\n', 'Samsung-Chromebook-3.png', 27350.76, 10, 5),
('P00032', 'C00001', 'S00004', 'Samsung', 'Samsung Chromebook Pro and Plus', 'Screen Size-12.3 inches\r\nProcessor-2 GHz None\r\nRAM-4 GB DDR3\r\nHard Drive-32 GB Flash Memory Solid State\r\nGraphics Coprocessor- integrated graphics\r\n', 'Samsung-Chromebook-Pro-and-Plus.png', 83933.97, 10, 5),
('P00033', 'C00001', 'S00005', 'Acer', 'Acer Aspire E 15', 'Screen Size-15.6 inches\r\nProcessor-2.4 GHz Intel Core i3\r\nHard Drive-1000 GB SATA\r\nGraphics Coprocessor- Intel HD Graphics 620\r\nChipset Brand- Intel\r\n', 'Acer Aspire E 15.png', 53411.97, 10, 5),
('P00034', 'C00001', 'S00005', 'Acer', 'Newest 2017 Acer', 'Screen Size-15.6 inches\r\nProcessor-3.1 GHz Intel Core i5\r\nRAM-16 GB\r\nHard Drive-1000 GB mechanical_hard_drive\r\nGraphics Coprocessor- NVIDIA GeForce\r\nOperating System- Windows 10\r\n', 'Newest-2017-Acer.png', 99194.97, 10, 5),
('P00035', 'C00001', 'S00005', 'Acer', 'Acer Aspire E5-575G-53VG', 'Screen Size- Screen Size\r\nProcessor-2.3 GHz Intel Core i5\r\nRAM-8 GB DDR4-SDRAM\r\nHard Drive-256 GB SATA\r\nGraphics Coprocessor- integrated graphics\r\n', 'Acer Aspire E5-575G-53VG.png', 152610.00, 10, 5),
('P00036', 'C00001', 'S00005', 'Acer', 'Acer Aspire VX 15 Gaming Laptop', 'Screen Size-15.6 inches\r\nProcessor-2.8 GHz Intel Core i7\r\nRAM-16 GB DDR4\r\nHard Drive- Flash Memory Solid State\r\nGraphics Coprocessor- GTX 1050 Ti\r\nOperating System- Windows 10\r\n', 'Acer Aspire VX 15 Gaming Laptop.png', 152457.39, 10, 5),
('P00037', 'C00001', 'S00006', 'Microsoft', 'Microsoft Surface Pro 4 ', 'Screen Size-12.3 inches\r\nProcessor-2.2 GHz Core M Family\r\nRAM-4 GB\r\nHard Drive-128 GB Flash Memory Solid State Drive\r\nGraphics Coprocessor- Intel Integrated Graphics\r\n\r\nOperating System- Windows 10 Pro\r\n', 'Microsoft-Surface-Pro-4.png', 101981.63, 10, 5),
('P00038', 'C00001', 'S00006', 'Microsoft', 'Microsoft Surface Pro 3', 'Screen Size-12 inches\r\nProcessor- Intel Core i7\r\nRAM-512 GB\r\nHard Drive-512 GB\r\nOperating System- windows_8.1_professional\r\n', 'Microsoft-Surface-Pro-3.png', 91405.76, 10, 5),
('P00039', 'C00001', 'S00006', 'Microsoft', 'iRULU Walknbook ', '10.1\" Hybrid 2-in-1 Laptop-32 GB, \r\nMicrosoft Windows 10\r\nDual Camera,\r\nDetachable Keyboard (Orange)\r\n\r\nCPU-Intel Bay trail-T Quad-Core Processor, up to 1.83 GHz\r\nScreen-10-point Capacitive Touchscreen\r\nResolution-1280x800 \r\nFront Camera-2.0MP \r\nRear Camera-5.0MP\r\nScreen Size-10.1 inches \r\nRAM/ROM-2GB/32GB (expandable) \r\nBattery-7 hours\r\nWireless-Wi-Fi 802.11 b/g/n\r\nSupports-HDMI port, USB, Bluetooth 4.0', 'iRULUWalknbook.png', 25942.17, 10, 5),
('P00040', 'C00001', 'S00006', 'Microsoft', 'Microsoft Surface 3 ', 'Screen Size-10 inches\r\nProcessor- Intel Atom\r\nRAM-4 GB\r\nHard Drive-128 GB\r\nOperating System- Windows 10\r\n', 'Microsoft-Surface-3.png', 59346.98, 10, 5),
('P00041', 'C00001', 'S00008', 'Apple', 'Apple A1181 MacBook MB403LL ', 'Screen Size-13.3 inches\r\nProcessor-2.1 GHz Intel Core 2 Duo Mobile\r\nRAM-2 GB ddr2_sdram\r\n\r\nHard Drive-120 GB mechanical_hard_drive\r\nGraphics Coprocessor- integrated graphics\r\n', 'A1181 Macbook MB403LL.png', 137349.00, 10, 5),
('P00042', 'C00001', 'S00008', 'Apple', 'Apple MacBook MLH82LL/A ', '1.2 GHz Dual-Core Intel Core M5 Processor (Turbo Boost up to 3.1 GHz) \r\n8 GB of 1866 MHz LPDDR3 RAM\r\n12-Inch IPS LED-backlit Display\r\nIntel HD Graphics 515\r\n', 'Apple MacBook MLH82LL.png', 126342.77, 10, 5),
('P00043', 'C00001', 'S00008', 'Apple', 'Apple MacBook MMGL2LL/A ', 'Screensize-12 inches\r\nProcessor-1.1 GHz core_m\r\nRAM-8 GB LPDDR3\r\nMemory Speed-1866\r\nOperating System- Mac OS X\r\n', 'Apple MacBook MMGL2LL.png', 119089.00, 10, 5),
('P00044', 'C00001', 'S00007', 'HP', '2017 HP Stream', '\r\nScreen Size-14 inches\r\nProcessor-1.6 GHz Intel Celeron\r\nRAM-4 GB SDRAM\r\nHard Drive-32 GB emmc\r\nOperating System- Windows 10\r\nGraphics Coprocessor- integrated graphics\r\n', '2017_HP_Stream_480x380.png', 28843.29, 10, 5),
('P00045', 'C00001', 'S00007', 'HP', '2017 HP x2', 'Screen Size-10.1 inches\r\nProcessor-1.44 GHz Intel Atom\r\nRAM-2 GB DDR3 SDRAM\r\nHard Drive-32 GB emmc \r\nGraphics Coprocessor- integrated graphics\r\nOperating System- Windows 10\r\n', '2017_HP_x2_480x380.png', 41052.09, 10, 5),
('P00046', 'C00001', 'S00014', 'Lenovo', 'ThinkPad T470 ', 'Up to 7th Generation Intel Core i7 \r\nUp to Windows 10 Pro 64 bit\r\n14\" anti-glare display, up to FHD (1920 x 1080) IPS with touch option\r\nUp to 32 GB DDR4 high-performance memory\r\nUp to 1 TB PCIe NVMe SSD or 500 GB HDD storage\r\nIntel HD Graphics 620\r\nIntel 8265 2 x 2 11 ac & Bluetooth 4.1\r\n', 'ThinkPad-T470.png', 151083.90, 10, 5),
('P00047', 'C00001', 'S00014', 'Lenovo', 'IdeaPad Y700 (15\")', 'Up to 6th Generation Intel Core i7 processor\r\nWindows 10 Home\r\nUp to 15.6\" UHD IPS AntiGlare LED Backlit (3840x2160) display (Select Models)\r\nUp to 16 GB DDR4 memory\r\nUp to 1 TB HDD with 512 GB PCIe SSD\r\nUp to NVIDIA GeForce GTX 960M 4 GB graphics\r\nUp to 5 hours battery life with standard battery\r\nUp to WiFi 2*2 AC + Bluetooth 4.0\r\n', 'IdeaPad-Y700.png', 152610.00, 10, 5),
('P00048', 'C00001', 'S00014', 'Lenovo', 'Lenovo N23 Chromebook', 'Intel Celeron dual-core processor\r\nChrome OS\r\n11.6\" HD (1366x768), 250-nit, anti-glare, 10-point multitouch display\r\nUp to 4GB LPDDR3 memory\r\nUp to 32GB eMMC storage\r\n802.11 AC 2x2 WiFi\r\nPorts: 2 USB 3.0, 2-in-1 card reader, HDMI, audio jack\r\nStarting at 1.25 kg\r\n', 'Lenovo-N23-Chromebook.png', 135670.29, 10, 5),
('P00049', 'C00001', 'S00014', 'Lenovo', 'Yoga 910 (14\")', 'Up to 7th Gen Intel Core i7 processor\r\nWindows 10 Home/Pro \r\n13.9\" UHD IPS Multi-touch (3840x2160) with integrated camera (Select Models)\r\nUp to 16 GB memory\r\nUp to 1 TB PCIe SSD storage\r\nUp to Intel HD graphics 620\r\n802.11 a/c 2x2 WiFi, Bluetooth 4.1\r\nUSB 3.0 Type-C with video-out, USB 2.0 Type-C with charging, USB 3.0 with always-on charging, audio combo jack\r\n\r\n', 'Yoga-910-(14).png', 190912.06, 10, 5),
('P00050', 'C00001', 'S00004', 'Samsung', 'Samsung Ativ Book 9 (2015) ', 'Screen Size-12.2 inches\r\nProcesso-r0.9 GHz Intel Core 2 Quad\r\nRAM-8 GB DDR3 SDRAM\r\nHard Drive-256 GB SSD\r\nGraphics Coprocessor- integrated graphics\r\nOperating System -windows, windows 10\r\n', 'Samsung-Ativ-Book-9-(2015).png', 45783.00, 10, 5),
('P00051', 'C00002', 'S00019', 'Alcatel', 'Alcatel Flint', '4G LTE Unlocked Any GSM Carrier Desbloqueados GSM (Not Verizon Sprint Net10 or Any CDMA Carrier)\r\n1 Micro SIM GSM: 850/900/1800/1900MHz - UMTS: 850/1900/2100MHz - LTE: Bands 2/4/5/17\r\nQuad Core 1.1 Ghz 16Gb (10.6 Gb User) 1.5GB Ram / 8Mp Camera Flash + 2mp Rear Camera\r\nAndroid 5.1.1 5.5-inch HD (1280 x 720).\r\n', 'Alcatel Flint.png', 18311.67, 10, 5),
('P00052', 'C00002', 'S00019', 'Alcatel', 'ALCATEL OneTouch Idol 3', 'Form factor	Touchscreen\r\nBattery capacity (mAh)	2610\r\nScreen size (inches)	5.20\r\nResolution	1080x1920 pixels\r\nProcessor	1.2GHz octa-core\r\nRAM	3GB\r\nInternal storage	16GB\r\nRear camera	13-megapixel\r\nOperating System	Android 6.0\r\n', 'ALCATEL OneTouch Idol 3.png', 22126.92, 10, 2),
('P00053', 'C00002', 'S00008', 'iphone', 'iPhone 7 Plus', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1080x1920 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Apple A10 Fusion\r\n\r\n\r\nBattery Capacity: 2900mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'iPhone 7 Plus.png', 128018.13, 10, 5),
('P00054', 'C00002', 'S00004', 'Samsung', 'Samsung Galaxy S7 edge', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 820\r\n\r\n\r\nBattery Capacity: 3600mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'Samsung Galaxy S7 Edge.png', 83778.50, 10, 4),
('P00055', 'C00002', 'S00011', 'Google', 'Google Pixel XL', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 821\r\n\r\n\r\nBattery Capacity: 3450mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'Google Pixel XL.png', 365421.39, 10, 5),
('P00056', 'C00002', 'S00008', 'iphone', 'Apple iPhone SE', 'Display Size: 4.0\"\r\n\r\n\r\nResolution:640x1136 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 2GB RAM\r\n\r\n\r\nChipset: Apple A9\r\n\r\n\r\nBattery Capacity: 1624mAh\r\n\r\n\r\nTechnology: Li-Po\r\n', 'Apple iPhone SE.png', 80582.57, 10, 5),
('P00057', 'C00002', 'S00012', 'OnePlus', 'OnePlus 3T', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:1080x1920 pixels\r\n\r\n\r\nPhoto: 16MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 6GB RAM\r\n\r\n\r\nChipset: Snapdragon 821\r\n\r\n\r\nBattery Capacity: 3400mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'OnePlus 3T.png', 72966.07, 10, 4),
('P00058', 'C00002', 'S00013', 'Huawei', 'Huawei Nexus 6P', 'Display Size: 5.7\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Snapdragon 810\r\n\r\n\r\nBattery Capacity: 3450mAh\r\n\r\n\r\nTechnology: Li-Po\r\n', 'Huawei Nexus 6P.png', 97564.32, 10, 5),
('P00059', 'C00002', 'S00014', 'LG', 'LG G5', 'Display Size: 5.3\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 16MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 820\r\n\r\n\r\nBattery Capacity: 2800mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'LG G5.png', 98862.17, 10, 4),
('P00060', 'C00002', 'S00015', 'HTC', 'HTC 10', 'Display Size: 5.2\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 12MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Snapdragon 820\r\n\r\n\r\nBattery Capacity: 3000mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'HTC 10.png', 106629.48, 10, 5),
('P00061', 'C00002', 'S00013', 'Huawei ', 'Huawei Mate 9', 'Display Size: 5.9\"\r\n\r\n\r\nResolution:1080x1920 pixels\r\n\r\n\r\nPhoto: 20MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 4GB RAM\r\n\r\n\r\nChipset: Hisilicon Kirin 960\r\n\r\n\r\nBattery Capacity: 4000mAh\r\n\r\n\r\nTechnology: Li-Po\r\n', 'Huawei Mate 9.png', 91245.67, 10, 5),
('P00062', 'C00002', 'S00016', 'Sony', 'Sony Xperia Z5 Premium', 'Display Size: 5.5\"\r\n\r\n\r\nResolution:2160x3840 pixels\r\n\r\n\r\nPhoto: 23MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Snapdragon 810\r\n\r\n\r\nBattery Capacity: 3430mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'Sony Z5 Premium.png', 67786.85, 10, 5),
('P00063', 'C00002', 'S00017', 'Motorola ', 'Motorola Moto X Force', 'Display Size: 5.4\"\r\n\r\n\r\nResolution:1440x2560 pixels\r\n\r\n\r\nPhoto: 21MP\r\n\r\n\r\nVideo: 2160p\r\n\r\n\r\nRAM: 3GB RAM\r\n\r\n\r\nChipset: Snapdragon 810\r\n\r\n\r\nBattery Capacity: 3760mAh\r\n\r\n\r\nTechnology: Li-Ion\r\n', 'Motorola Moto X Force.png', 45697.50, 10, 5),
('P00064', 'C00002', 'S00019', 'Alcatel', 'Alcatel A3 XL', 'Form factor- Touchscreen\nBattery capacity (mAh)- 3000\nScreen size (inches)- 6.00\nProcessor-1.1GHz quad-core\nRAM-1GB\nInternal storage-8GB\nRear camera-8-megapixel\n	Operating System- Android 7.0\n\n', 'Alcatel A3 XL-price.png', 45781.47, 10, 5),
('P00065', 'C00002', 'S00019', 'Alcatel', '\r\n\r\nAlcatel One Touch Pop 2 \r\n', 'Form factor -Touchscreen\n  Battery capacity (mAh) -2500\nScreen size (inches) -5.00\nProcessor1.2GHz quad-core\nRAM-1GB\n Internal storage-8GB\nRear camera5-megapixel\nOperating System- Android 5.0\n', 'Alcatel One Touch Pop 2.png', 106825.47, 10, 5),
('P00066', 'C00002', 'S00019', 'Alcatel', 'Alcatel Idol 4S', 'CPU Model Speed:1.2 GHz\r\n\r\nForm factor- Touchscreen\r\nBattery capacity (mAh)- 2910\r\nScreen size (inches)- 5.50\r\nResolution-1080x1920 pixels\r\nProcessor-1GHz octa-core\r\nRAM-2GB\r\nInternal storage-16GB\r\nRear camera-13-megapixel\r\nOperating System- Android 5.0\r\n', 'Alcatel Idol 4S-price.png', 76303.47, 10, 5),
('P00067', 'C00002', 'S00008', 'iphone', 'Apple iPhone 6S', 'Sim - Nano-SIM / Fingerprint Sensor \r\nDisplay - Type - LED-Backlit IPS LCD, Capacitive Touchscreen, 16M Colors\r\nSize - 4.7 Inches\r\nResolution - 750 x 1334 Pixels (~326 PPI Pixel Density)\r\nPlatform - OS - iOS 9\r\nInternal - 16 GB\r\nCamera - Primary - 12 MP, 4608 x 2592 Pixels, , Dual-LED (Dual Tone) Flash\r\nVideo - 2160p@30fps, 1080p@60fps, 1080p@120fps, 720p@240fps\r\nSound - Alert Types - Vibration, Proprietary Ringtones\r\nBluetooth - v4.1, A2DP, LE\r\nBattery - Non-Removable Li-Po 1810 mAh Battery (6.9 Wh)\r\n', 'Apple iPhone 6S.png', 126971.52, 10, 5),
('P00068', 'C00002', 'S00008', 'iphone', 'iPhone 6', '7\" Retina HD display\r\nNew 8-megapixel iSight camera with 1.5 pixels\r\nA8 chip with 64-bit architecture\r\nSpecifications: Processor: Intel Celeron N3060 1.6GHz (Turbo up to 2.48GHz) 2MB\r\nCache Processor Core: Dual-Core Screen Size: 14\" Aspect Ratio: 16:9\r\nResolution: 1366 x 768 Display Type: HD Anti-Glare LED-backlit Graphics: Intel HD Graphics 400\r\nMemory: 4GB DDR3 (on-board)\r\n Hard Drive: 16GB eMMC Solid State Drive \r\n', 'iPhone 6-5d5a.png', 50699.00, 10, 5),
('P00069', 'C00002', 'S00008', 'iphone', 'Apple iPhone 5S', 'Type: LED-backlit IPS LCD,\r\n Capacitive touchscreen, 16M colors, Size: 4.0 inches \r\n Resolution: 640 x 1136 pixels \r\n OS: iOS 7,\r\n CPU: Dual-core 1.3 GHz Cyclone (ARM v8-based)\r\n GPU: PowerVR G6430 (quad-core graphics)\r\n 8 Megapixel Camera (3264 x 2448 pixels) w/ Autofocus, dual-LED  (dual tone) Flash + Front-Facing 1.2 Megapixel Camera,  720p@30fps, face detection, FaceTime over Wi-Fi or Cellular\r\n', 'Apple iPhone 5S.png', 114304.89, 10, 5),
('P00070', 'C00002', 'S00011', 'Google', 'Google Pixel', 'Screen cize-5.50inch\r\nStorage-32GB\r\nProcessor-1.6GHz quad-core\r\n\r\nRAM-4GB\r\nRear camera-12.3megapixel\r\nOS-android 7.1\r\nBattery capacity-3450mAh\r\n', 'Google Pixel.png', 117357.09, 10, 5),
('P00071', 'C00001', 'S00011', 'Google', 'Google Pixel C', 'Screen cize-10.20inch\r\nStorage-32GB\r\nProcessor-octa-core\r\n\r\nRAM-3GB\r\nRear camera-8megapixel\r\nOS-android 6.0\r\nBattery capacity-3000mAh\r\n', 'Google Pixel C.png', 118883.19, 10, 5),
('P00072', 'C00002', 'S00011', 'Google', 'Google Pixel 32GB', 'Screen cize-5.0inch\r\nStorage-32GB\r\nProcessor-1.6GHz quad-core\r\n\r\nRAM-4GB\r\nRear camera-12.3megapixel\r\nOS-android 7.1\r\nBattery capacity-2770mAh\r\n', 'Google Pixel 32GB.png', 91566.00, 10, 5),
('P00073', 'C00002', 'S00011', 'Google', 'Google Pixel 128GB Quite Black Unlocked Fair', 'Screen cize-5.0inch\r\nStorage-32GB\r\nProcessor-1.6GHz quad-core\r\n\r\nRAM-4GB\r\nRear camera-12.3megapixel\r\nOS-android 7.1\r\nBattery capacity-2770mAh\r\n', 'Google Pixel 128GB Quite Black Unlocked Fair.png', 99043.89, 10, 5),
('P00074', 'C00002', 'S00015', 'HTC', 'HTC  M8', 'Processor-2.5GHz\r\nOS-android 4.4.2 \r\nDisplay-5inch\r\nStorage-16GB\r\nRAM-2GB\r\nRear camera-4ultrapixel\r\nBattery-2600mAh \r\n', 'HTC M8.png', 30369.39, 10, 5),
('P00075', 'C00002', 'S00015', 'HTC', 'HTC  M9', 'Processor-1.5GHz\r\n OS-android 5.0 \r\nDisplay-5inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-4ultrapixel\r\nBattery-2840mAh\r\n', 'HTC M9.png', 106674.39, 10, 5),
('P00076', 'C00002', 'S00015', 'HTC', 'HTC  M10', 'Processor-2.56GHz\r\nOS-android 5.0 \r\nDisplay-5.5inch\r\nStorage-32GB\r\nRAM-4GB\r\nRear camera-12megapixel\r\nBattery-3000mAh\r\n', 'HTC-M10.png', 121935.39, 10, 5),
('P00077', 'C00002', 'S00015', 'HTC', 'HTC one mini 2', 'Processor-1.2GHz\r\n OS-android 4.4 \r\nDisplay-4.5inch\r\nStorage-16GB\r\nRAM-1GB\r\nRear camera-13megapixel\r\nBattery-2100mAh\r\n', 'HTC-one-mini-2.png', 118577.97, 10, 5),
('P00078', 'C00002', 'S00013', 'Huawei', 'Huawei P9 EVA-L09 ', 'OS- Android\r\n RAM3 -GB\r\nWireless communication technologies- Bluetooth, WiFi Hotspot\r\nSpecial features- Single SIM, GPS, Music Player, Video Player, Fingerprint sensor, G sensor, Gyroscope sensor, eCompass, Ambient light sensor, Proximity sensor, Hall effect sensor, E-mail\r\nBattery Power Rating- 3000\r\nForm factor -Touchscreen Phone\r\n', 'Huawei-P9-EVA-L09.png', 52650.45, 10, 5),
('P00079', 'C00002', 'S00013', 'Huawei ', 'Huawei Y541-U02 ', 'OS- android\r\nRAM-1 GB\r\nSpecial features-11.4CM (4.5\") LCD Screen, 8MP Main Camera & 2 MP Front camera with DUAL LED Flash, 1730 mAh Battery, Android 4.4 Kitkat, 1.2 GHz Quad Core Processor, 1GB RAM + 8GB\r\nBattery Power Rating-1730mAh\r\n', 'Huawei-Y541-U02.png', 22738.89, 10, 5),
('P00080', 'C00002', 'S00013', 'Huawei ', 'Huawei Honor Bee 4G', 'Form factor Touchscreen Phone\r\nOS- Android\r\nBattery Power Rating3000 \r\nWireless communication technologies Bluetooth, Wi-Fi Hotspot camera6MP\r\nSpecial features Single SIM, GPS, Music Player, Video Player, Fingerprint sensor, G sensor, and Gyroscope sensor\r\n', 'Huawei-Honor-Bee-4G.png', 76152.39, 10, 5),
('P00081', 'C00002', 'S00012', 'OnePlus', 'Oneplus 3', 'Screen size- 5.50inch\r\nResolution-1080*1920pixels\r\nStorage-64GB\r\nRear camera-16-megapixel\r\nRAMS-6GB\r\nProcessor-1.6GHz\r\nOS-android 6.0.1\r\nBattery capacity-3000mAh\r\nDuel sim\r\n', 'Oneplus-3.png', 76152.39, 10, 5),
('P00082', 'C00002', 'S00012', 'OnePlus', 'Oneplus 2', 'Price-399.99\r\nScreen size- 5.50inch\r\nResolution-1080*1920pixels\r\nStorage-64GB\r\nRear camera-13-megapixel\r\nRAMS-4GB\r\nProcessor-1.8GHz\r\nOs-oxygenOS 2.0\r\nBattery capacity-3300mAh\r\n', 'Oneplus-2.png', 60891.39, 10, 5),
('P00083', 'C00002', 'S00012', 'OnePlus', 'Oneplus 4', 'Screen size- 5.50inch\r\nResolution-1080*1920pixels\r\nStorage-64GB\r\nRear camera-16-megapixel\r\nRAMS-8GB\r\nProcessor-3GHz\r\nOs-oxygenOS 2.0\r\nBattery capacity-4000mAh\r\nDuel sim\r\n', 'Oneplus-4.png', 106674.39, 10, 5),
('P00084', 'C00002', 'S00012', 'OnePlus', 'Oneplus one', 'Screen size- 5.46inch\r\nResolution-1080*1920pixels\r\nStorage-16GB\r\nRear camera-13-megapixel\r\nRAMS-3GB\r\nProcessor-3GHz\r\nOs-oxygenOS 2.1.4\r\nBattery capacity-4000mAh\r\nDuel sim\r\n', 'Oneplus-1.png', 30369.39, 10, 5),
('P00085', 'C00002', 'S00018', 'Oppo', 'OPPO NEO 7', 'Sim - Dual Sim (Nano-Sim/Micro-Sim)\r\nDisplay - Type - IPS LCD Capacitive Touchscreen, 16M Colors\r\nSize - 5.0 Inches\r\nResolution - 540 x 960 Pixels (~220 PPI Pixel Density)\r\n\r\nPlatform - OS - Android OS, v5.1 (Lollipop)\r\nMemory - Card Slot - MicroSD (Dedicated Slot), up to 256 GB\r\nInternal - 16 GB, 1 GB RAM\r\nCamera - Primary - 8 MP, Autofocus, LED Flash\r\nVideo - 1080p@30fps\r\nBluetooth - v4.0, A2DP\r\nBattery - Non-Removable Li-Po 2420 mAh Battery\r\n', 'OPPO-NEO-7.png', 91564.47, 10, 5),
('P00086', 'C00002', 'S00018', 'Oppo', 'OPPO A37', 'Sim - Dual Sim (Nano-Sim, Dual Stand-by)\r\nDisplay - Type - IPS LCD Capacitive Touchscreen, 16M Colors\r\nSize - 5.0 Inches (~67.8% screen-to-body ratio)\r\nResolution - 720 x 1280 Pixels (~294 PPI Pixel Density)\r\n\r\nPlatform - OS - Android OS, v5.1 (Lollipop)\r\n\r\nMemory - Card Slot - MicroSD, up to 256 GB (Dedicated Slot)\r\nInternal - 16 GB, 2 GB RAM\r\nCamera - Primary - 8 MP, Autofocus, LED Flash\r\nVideo - 1080p@30fps\r\n\r\nBluetooth - v4.0, A2DP\r\nBattery - Non-Removable Li-Ion 2630 mAh Battery\r\n', 'OPPO-A37.png', 106674.39, 10, 5),
('P00087', 'C00002', 'S00018', 'Oppo', 'OPPO A57\r\n', 'Sim - Dual Sim (Nano-Sim, Dual Stand-by)\r\nDisplay - Type - IPS LCD Capacitive Touchscreen, 16M Colors\r\nSize - 5.2 Inches \r\nResolution - 720 x 1280 Pixels (~282 PPI Pixel Density)\r\nPlatform - OS - Android OS, v6.0 (Marshmallow)\r\nMemory - Card Slot - MicroSD, up to 256 GB (Uses Sim 2 Slot)\r\nInternal - 32 GB, 3 GB RAM\r\nCamera - Primary - 13 MP, Phase Detection Autofocus, LED Flash\r\nVideo - 1080p@30fps\r\nBattery - Non-Removable Li-Ion 2900 mAh Battery\r\n', 'OPPO-A57.png', 121935.39, 10, 5),
('P00088', 'C00002', 'S00018', 'Oppo', 'Oppo R9s Plus', 'Form factor -Touchscreen\r\nBattery capacity (mAh) -4000\r\nScreen size (inches)- 6.00\r\nProcessor-1.95GHz octa-core\r\nRAM-6GB\r\nInternal storage-64GB\r\nRear camera-16-megapixel\r\nOperating System- Android 6.0\r\n', 'Oppo-R9s-Plus.png', 91413.39, 10, 5),
('P00089', 'C00002', 'S00018', 'Oppo', 'Oppo A30', 'Form factor Touchscreen\r\nProcessor2.3GHz quad-core\r\nRAM3GB\r\nInternal storage16GB\r\nRear camera13-megapixel\r\nOperating System Android 5.1\r\n', 'Oppo-A30.png', 76152.39, 10, 5),
('P00090', 'C0002', 'S00016', 'LG', 'LG G4', 'Processor-qualcomm snapdragon 808 with x10 LTE\r\nOS-android 5.1 lollipop\r\nDisplay-5.5inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-16megapixel\r\nBattery-3000mAh\r\n', 'LG-G4.png', 37999.89, 10, 5),
('P00091', 'C00002', 'S00016', 'LG', 'LG G3', 'Processor-2.46GHz\r\nOS-android 4.4.2\r\nDisplay-5.5inch\r\nStorage-16GB\r\nRAM-2GB\r\nRear camera-13megapixel\r\nBattery-3000mAh\r\n', 'LG-G3.png', 19534.08, 10, 5),
('P00092', 'C00002', 'S00016', 'LG', 'LG G7', 'Processor-qualcomm snapdragon 830 SoC\r\nOS-android 5.1 lollipop\r\nDisplay-5.4inch\r\nStorage-32GB\r\nRAM-6GB\r\nRear camera-22megapixel\r\nBattery-3000mAh\r\n', 'LG-G7.png', 22738.89, 10, 5),
('P00093', 'C00002', 'S00014', 'LG', 'LG G6', 'Processor-qualcomm snapdragon 808 with x10 LTE\r\nOS-android 7.0 \r\nDisplay-5.7inch\r\nStorage-32GB\r\nRAM-4GB\r\nRear camera-16megapixel\r\nBattery-3300mAh\r\n', 'LG-G6.png', 12056.19, 10, 5),
('P00094', 'C00002', 'S00016', 'Sony', 'Sony xperia xz', 'Processor-2.46GHz\r\nOS-android 6.0.1 \r\nDisplay-5.2inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-16megapixel\r\nBattery-3000mAh\r\n', 'Sony-xperia-xz.png', 76152.39, 10, 5),
('P00095', 'C00002', 'S00016', 'Sony', 'Sony xperia xA', 'Processor-1.5GHz octa-core\r\n OS-android 6\r\nDisplay-5.2inch\r\nStorage-16GB\r\nRAM-2GB	\r\nRear camera-13megapixel\r\nBattery-3000mAh\r\n', 'Sony-xperia-xA.png', 84698.55, 10, 5),
('P00096', 'C00002', 'S00016', 'Sony', 'Sony xperia x6', 'Processor-2.5GHz\r\n OS-android 7.0 \r\nDisplay-5.7inch\r\nStorage-32GB\r\nRAM-3GB\r\nRear camera-16megapixel\r\nBattery-3300mAh\r\n', 'Sony-xperia-x6.png', 87140.31, 10, 5),
('P00097', 'C00002', 'S00016', 'Sony', 'Sony xperia ', 'Processor-1.96GHz\r\n OS-android 4.1.2 \r\nDisplay-4.3inch\r\nStorage-16GB\r\nRAM-1GB\r\nRear camera-13megapixel\r\nBattery-3000mAh\r\n', 'Sony-xperia.png', 76152.39, 10, 5),
('P00098', 'C00002', 'S00004', 'Samsung', 'Samsung On5 Pro', 'OS- Android\r\nRAM-2 GB\r\nWireless communication technologies- Bluetooth, WiFi Hotspot\r\nSpecial features- Dual SIM, GPS, Music Player, Video Player, FM Radio, Accelerometer, Proximity sensor\r\nCamera-8MP primary & 5MP front\r\nForm factor- Touchscreen Phone\r\nBattery Power Rating-2600\r\n\r\n', 'Samsung On5 Pro.png', 34699.00, 10, 5),
('P00099', 'C00002', 'S00004', 'Samsung', 'Samsung Galaxy C7 Pro', 'OS- Android\r\nRAM-4 GB\r\nWireless communication technologies- Bluetooth, WiFi Hotspot\r\nSpecial features- Dual SIM, GPS, Music Player, Video Player, FM Radio, Accelerometer, Fingerprint sensor\r\nCamera-16MP\r\nForm factor- Touchscreen Phone\r\nBattery Power Rating-3300\r\n', 'Samsung Galaxy C7 Pro.png', 27599.00, 10, 5),
('P00100', 'C00002', 'S00004', 'Samsung', 'Samsung Galaxy J2', 'OS- Android\r\nRAM-2 GB \r\nForm factor- Touchscreen Phone\r\nBattery Power Rating-2600 \r\nSpecial features -Dual SIM, GPS, Music Player, Video Player, FM Radio, Accelerometer, Proximity sensor, E-mail \r\nCamera-8MP primary & 5MP front \r\n', 'Samsung Galaxy J2.png', 15599.00, 10, 5),
('P00101', 'C00002', 'S00004', 'Samsung', 'Samsung Galaxy On8', 'OS- Android\r\nRAM-3 GB\r\nBatteries-1 Lithium ion batteries\r\nWireless communication technologies- Bluetooth, WiFi Hotspot camera-13MP Primary | 5MP Secondary\r\nBattery Power Rating-3300\r\n', 'Samsung Galaxy On8.png', 32299.00, 10, 5),
('P00102', 'C00002', 'S00017', 'Motorola ', 'Motorola Moto G5 Plus\r\n', 'Display-5.2 inches\r\nProcessor. 2.5GHz quad-core.\r\nFront Camera. 2-megapixel.\r\nResolution. 720x1280 pixels.\r\nRAM. 3GB.\r\nOS. Android 7.0\r\nStorage. 32GB.\r\nRear Camera. 13-megapixel.\r\n', 'Motorola Moto G5 Plus .png', 16999.00, 10, 5),
('P00103', 'C00002', 'S00017', 'Motorola ', 'Motorola Moto G5', 'Display-5.00 inches\r\nProcessor. 1.5GHz quad-core.\r\nFront Camera. 2-megapixel.\r\nResolution. 720x1280 pixels.\r\nRAM. 2GB.\r\nOS. Android 7.0\r\nStorage. 32GB.\r\nRear Camera. 13-megapixel.\r\n', 'Motorola Moto G5.png', 11999.00, 10, 5),
('P00104', 'C00002', 'S00017', 'Motorola ', 'Motorola Moto G4 Plus\r\n', 'Display- 5.5 inches \r\nProcessor. 2.5GHz quad-core.\r\nFront Camera. 16 MP.\r\n.\r\nRAM. 3GB.\r\nOS. - Android 6.0.1\r\nStorage. 32GB.\r\nRear Camera. 13-megapixel\r\n', 'Motorola Moto G4 Plus .png', 12499.00, 10, 5),
('P00105', 'C00002', 'S00017', 'Motorola ', 'Motorola Moto G (3rd gen)\r\n\r\n', 'Display- 5.0 inches\r\nProcessor. 1.5GHz quad-core.\r\nFront Camera. 16 MP.\r\n.\r\nRAM. 2GB.\r\nOS. - Android 5.1.1\r\nStorage. 16GB.\r\nRear Camera. 13-megapixel\r\n', 'Motorola Moto G (3rd gen) .png', 9999.00, 10, 5),
('P00106', 'C00003', 'S00021', 'DigitalStorm', '  Eset smart security ', 'The two new products ESET Internet Security and ESET Smart Security Premium include many new features such as script-based attack protection, webcam protection, home network protection, password manager and secure data. Continue reading below for an overview of the new and improved features. \r\n', 'Eset smart security.png', 1850.00, 10, 5),
('P00107', 'C00003', 'S00021', 'DigitalStorm', 'Topre Realforce RGB-keyboard ', 'The REALFORCE RGB includes high quality, double-shot sculpted keycaps to retain the premium feel, durability, and design. But what if you want more customization? REALFORCE RGB has you covered with MX stem compatibility so you can switch up your style with any 3rd party accessory keycaps.\r\n', 'Topre Realforce RGB keyboard.png', 36.53, 10, 5),
('P00108', 'C00003', 'S00021', 'DigitalStorm', '  Logitech MX Anywhere-Mouse ', 'Darkfield laser tracking gives you flawless control on virtually any surface, including glass and high-gloss surfaces.\r\nThis wireless travel mouse performs anywhere you need it to-glass tables in your hotel room, shiny laminate tops, train and airplane tray tables, and even your jeans. Unlike traditional laser and optical mice which use irregularities on the surface to track mouse movements, Darkfield technology uses the smallest possible detail to create a micro-road map of the surface.\r\nIn tests, the mouse performed best on glass with a minimum thickness of 4mm.\r\n', 'Logitech MX Anywhere Mouse.png', 4489.55, 10, 5),
('P00109', 'C00003', 'S00021', 'DigitalStorm', 'Google Jam Board', 'The newest addition to G Suite, Jamboard merges the worlds of physical and digital creativity. It\'s real time collaboration on a brilliant scale, whether your team is together in the conference room or spread all over the world.\r\n\r\n\r\n', 'Google Jam Board.png', 913.00, 10, 5),
('P00110', 'C00003', 'S00115', 'DigitalStorm', 'Hard Disk', 'Specifications \r\nModel Number ST3500630AS\r\nInterface SATA 3Gb/s\r\nCache 16MB\r\nCapacity 500GB\r\nGuaranteed Sectors 976,773,168', 'Hard Disk.png', 35800.00, 10, 5),
('P00111', 'C00003', 'S00021', 'DigitalStorm', 'Video graphic Array (VGA)', 'Specifications \r\nModel Number ST3500630AS\r\nInterface SATA 3Gb/s\r\nCache 16MB\r\nCapacity 500GB\r\nGuaranteed Sectors 976,773,168', 'vga.png', 35800.00, 10, 5),
('P00112', 'C00003', 'S00021', 'DigitalStorm', ' wireless Router ', '\r\nGigabit FTTH Router ONU WiFi Router with IPTV/VoIP/CATV/WiFi Onaccess 454wr', 'TP link wireless N USB ADSL2 + Modem Router.png', 5750.00, 10, 5),
('P00113', 'C00003', 'S00021', 'DigitalStorm', '  Logitech HDwebcam C170', 'Connect with everyone in Full HD 1080p on Skype, or in fluid HD 720p on FaceTime for Mac.\r\nAlso make high-quality video calls with Google Hangouts and video-calling clients. \r\nEven chat with your Facebook friends with video calling powered by Skype or Facebook Messenger.\r\n', 'Logitech HDwebcam C170.png', 2400.00, 10, 5),
('P00114', 'C00003', 'S00021', 'DigitalStorm', '  EPSON M100 Printer', 'Epson\'s fast-drying genuine pigment ink ensures business documents are water, smudge and fade resistant, while Micro Piezo technology offers Epson-quality document printing. In addition, a 12-month (or 50,000-page) warranty, and additional service support, provide peace of mind and help if you need it.', 'EPSON M100 Printer.png', 26.00, 10, 5),
('P00115', 'C0004', 'S00022', 'Fone', 'Portable Power Bank  ', 'B&H # XUBUBA26B MFR # BUB-A26B\r\nTOP HIGHLIGHTS\r\nUltra Compact Design\r\n2600 mAh Battery Capacity\r\nCompatible with USB Powered Devices\r\n', 'portable power Bank.png', 699.00, 10, 5),
('P00116', 'C0004', 'S00022', 'Fone', 'In-Ear Headphones Headset ', 'Mini Wireless Bluetooth V4.1 Stereo Sound In - Ear Headphone with Mic for Tablet PC Smartphones  ', 'White In-Ear Headphones.png', 200.00, 10, 5),
('P00117', 'C0004', 'S00022', 'Fone', 'Metal Earphone handsfree Headphones', 'Although on-ear and over-ear headphones are \'in\' right now, there\'s still a place for in-ear headphones, which offer much more portability and convenience. \r\n\r\nAfter all, it\'s incredibly easy to just throw a pair of earbuds into your pocket, rather than worrying about having to wear a pair of headphones around your neck or carrying them in a bag. ', 'High Quality Stereo Headset In Ear Metal Earphone handsfree.png', 150.00, 10, 5),
('P00118', 'C0004', 'S00022', 'Fone', 'Wireless Bluetooth 4.0 Headset ', 'B&H # PARPTCM125K MFR # RP-TCM125-K\r\nErgoFit Design\r\nIn-Line Single Button Remote & Mic\r\niPhone, Blackberry, Palm Compatibility\r\nIncludes 3 Pairs of Earpads', 'Wireless Bluetooth 4.0 Headset .png', 3100.00, 10, 5),
('P00119', 'C0004', 'S00022', 'Fone', 'New Android phone charger ', 'Ports 2A USB EU Plug Charging Mobile Phone Adapter Dock Wall Charger Cell for iPhone 7 6s 6 5s 4s ipad Android Samsung Charge', 'Mivi Dual Port Car Mobile Charger with Fast Charging.png', 2500.00, 10, 5),
('P00120', 'C0004', 'S00022', 'Fone', '3D Back Covers ', 'silicon,plastic,leather,metal,crystal,etc', 'Samsung Galaxy J7 Prime 3D Back Covers By Renowned.png', 325.00, 10, 5),
('P00121', 'C0004', 'S00022', 'Fone', 'BT2046 Wireless Bluetooth Headset ', 'Jabra Sport Wireless + Bluetooth Headset \r\nIntegrated Mic for Taking Calls\r\nBuilt-In FM Radio\r\nRain, Shock, & Dust Resistant\r\n4 Hours of Talk Time', 'Jabra BT2046 Wireless Bluetooth Headset.png', 755.00, 10, 5),
('P00122', 'C0004', 'S00022', 'Fone', 'Dual Port Car Mobile Charger ', 'Charger over voltage protection\r\nCharger over-current protection\r\nThe charging circuit protection\r\nBatteries as the overcharge protection\r\nBatteries discharge protection\r\nThe electric core over current protection\r\n', 'Dual Port Car Mobile Charger .png', 595.00, 10, 5),
('P00123', 'C0004', 'S00022', 'Fone', 'Selfie Stick with Auxillary Cable ', 'Easy to use Easy to carry, adjustable Selfie stick monopod\r\nNo need to charge, no hassle of connecting through\r\nCampiatable with all smartphones & Iphone\r\nDisclaimer: Product may slightly change in photography or as per market availability but quality, pattern and purpose are fulfilled 100 percent', 'Digitek Black Selfie Stick with Auxillary Cable.png', 799.00, 10, 5),
('P00124', 'C0004', 'S00022', 'Fone', 'MicroSDHC Class 10 48 MB/s ', 'Capacity: Customized\r\nMemory Card Application: Cell Phone\r\nSpeed Grade: Class 10\r\nNand Flash Chips: Original and Good Die(SLC, MLC, Tlc)\r\nTrademark: Digital Legend or OEM brands', 'Samsung EVO 32GB MicroSDHC.png', 899.00, 10, 5);

-- --------------------------------------------------------

--
-- Table structure for table `shipper`
--

CREATE TABLE `shipper` (
  `ShipperID` varchar(10) NOT NULL,
  `ProductID` varchar(10) NOT NULL,
  `CompanyName` varchar(30) NOT NULL,
  `PhoneNo` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipper`
--

INSERT INTO `shipper` (`ShipperID`, `ProductID`, `CompanyName`, `PhoneNo`) VALUES
('Ship00001', 'P00001', 'Dell', 772569845),
('Ship00002', 'P00002', 'Asus', 725639853),
('Ship00003', 'P00003', 'Razer', 742369875),
('Ship00004', 'P00005', 'Samsung', 746987253),
('Ship00005', 'P00006', 'Acer', 785634789),
('Ship00006', 'P00008', 'Microsoft', 712369854),
('Ship00007', 'P00009', 'HP', 754214563),
('Ship00008', 'P00010', 'Apple', 775542545),
('Ship00009', 'P00014', 'Lenovo', 784562886),
('Ship00010', '', 'Toshiba', 778954210),
('Ship00011', 'P00018', 'Google', 754123952),
('Ship00012', 'P00020', 'OnePlus', 784562584),
('Ship00013', 'P00021', 'Huawei', 778456221),
('Ship00014', 'P00022', 'LG', 778523691),
('Ship00015', 'P00023', 'HTC', 723698741),
('Ship00016', 'P00025', 'Sony', 784126655),
('Ship00017', 'P00026', 'Motorola Moto', 712365588),
('Ship00018', '', 'Oppo', 725983694),
('Ship00019', '', 'Alcatel', 762584660),
('Ship00020', '', 'Micromax', 775698123),
('Ship00021', '', 'Digital Storm', 715683565),
('Ship00022', '', 'fone', 725694123),
('Ship00023', 'P00004', 'Asus', 786954223),
('Ship00024', 'P00011', 'Asus', 783698514),
('Ship00025', 'P00007', 'Samsung', 756932159),
('Ship00026', 'P00012', 'HP', 778549632),
('Ship00027', 'P00015', 'HP', 789563879),
('Ship00028', 'P00013', 'Apple', 769854723),
('Ship00029', '', 'Apple', 789654236),
('Ship00030', 'P00024', 'Huawei', 785694896),
('Ship00031', 'P00016', 'Apple', 789645889),
('Ship00032', 'P00017', 'Samsung', 112787875),
('Ship00033', 'P00019', 'Apple', 749856938),
('Ship00034', 'P00027', 'Digital Storm', 789632598),
('Ship00035', 'P00028', 'Digital Storm', 112785458),
('Ship00037', 'P00029', 'Digital Storm', 112857496),
('Ship00038', 'P00030', 'Digital Storm', 758574961),
('Ship00039', 'P00031', 'Digital Storm', 765432198),
('Ship00040', 'P00032', 'Digital Storm', 786554533),
('Ship00041', 'P00033', 'Digital Storm', 786540099),
('Ship00042', 'P00034', 'Digital Storm', 721234323),
('Ship00043', 'P00035', 'Digital Storm', 786532456),
('Ship00044', 'P00036', 'fone', 765849483),
('Ship00045', 'P00037', 'fone', 785462347),
('Ship00046', 'P00038', 'fone', 785443219),
('Ship00047', 'P00039', 'fone', 721345768),
('Ship00048', 'P00040', 'fone', 764532100),
('Ship00049', 'P00041', 'fone', 712347554),
('Ship00050', 'P00042', 'fone', 712340097),
('Ship00051', 'P00043', 'fone', 778434656),
('Ship00052', 'P00044', 'fone', 775443964),
('Ship00053', 'P00045', 'fone', 751236554);

-- --------------------------------------------------------

--
-- Table structure for table `shoppingcart`
--

CREATE TABLE `shoppingcart` (
  `CartID` int(10) NOT NULL,
  `total` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shoppingcart`
--

INSERT INTO `shoppingcart` (`CartID`, `total`) VALUES
(1, 0.00),
(2, 0.00),
(3, 204866.67),
(5, 0.00),
(6, 0.00),
(7, 423278.76),
(8, 423278.76),
(9, 0.00),
(10, 861666.22),
(11, 861666.22),
(12, 861666.22),
(13, 861666.22),
(14, 898193.22),
(15, 898193.22),
(16, 898193.22),
(17, 898193.22),
(18, 1067674.32),
(19, 1848188.88),
(20, 863288.11),
(21, 0.00),
(22, 861438.11),
(23, 630048.84),
(24, 858121.23),
(25, 858121.23),
(26, 515531.06),
(27, 515531.06),
(28, 705791.23),
(29, 705791.23),
(30, 705791.23),
(31, 705791.23),
(32, 705791.23),
(33, 705791.23),
(34, 705791.23),
(35, 705791.23),
(36, 705791.23),
(37, 705791.23),
(38, 705791.23),
(39, 705791.23),
(40, 705791.23),
(41, 705791.23),
(42, 515531.06),
(43, 515531.06),
(44, 643549.19),
(45, 643549.19),
(46, 278127.80),
(47, 18429557.67),
(48, 413696.29),
(49, 413696.29),
(50, 354622.72);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE `supplier` (
  `SupplierID` varchar(10) NOT NULL,
  `ComapnyID` varchar(10) NOT NULL,
  `S_fname` varchar(30) NOT NULL,
  `S_lname` varchar(30) NOT NULL,
  `S_email` varchar(30) NOT NULL,
  `S_ContactNo` int(10) NOT NULL,
  `S_City` varchar(15) NOT NULL,
  `CompanyName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`SupplierID`, `ComapnyID`, `S_fname`, `S_lname`, `S_email`, `S_ContactNo`, `S_City`, `CompanyName`) VALUES
('SID00001', 'S00001', 'Amal', 'Perara', 'amal1@gmail.com', 452226783, 'Kandy', 'Dell'),
('SID00002', 'S00002', 'Bathiya', 'Jayakodi', 'bathi@gmail.com', 754512467, 'Malabe', 'Asus'),
('SID00003', 'S00003', 'Chamara', 'Weerasingha', 'cw1@gmail.com', 712376518, 'Kotte', 'Razer'),
('SID00004', 'S00004', 'Dasun', 'Disanayake', 'dasu@gmail.com', 761230975, 'Hambantota', 'Samsung'),
('SID00005', 'S00005', 'Erandi', 'Lakmali', 'mali@gmail.com', 781250445, 'Embilipitiya', 'Acer'),
('SID00006', 'S00006', 'Fathima', 'Abdul', 'fathima@gmail.com', 773455431, 'Matara', 'Microsoft'),
('SID00007', 'S00007', 'Gayani', 'Amarasingha', 'gayani@gmail.com', 770998888, 'Kurunagala', 'HP'),
('SID00008', 'S00008', 'Hashini', 'Rajapaksha', 'hashini@gmail.com', 771420998, 'Matara', 'Apple'),
('SID00009', 'S00009', 'Ishanka', 'Perara', 'Ishanka12@gmail.com', 784328936, 'Matara', 'Lenovo'),
('SID00010', 'S00010', 'Hashini', 'Weerakoon', 'Hashini.weerakoon@gmail.com', 753867320, 'Jaffna', 'Toshiba'),
('SID00011', 'S00011', 'Jayani', 'Subhasingha', 'Jayani345@gmail.com', 782937810, 'Bandarawela', 'Google'),
('SID00012', 'S00012', 'Kasun', 'Samarasingha', 'kasun123@gmail.com', 775678990, 'Kegalle', 'OnePlus'),
('SID00013', 'S00013', 'Lasith', 'Galapaththi', 'Lasith@gmail.com', 115644972, 'Badulla', 'Huawei'),
('SID00014', 'S00014', 'Mahesh', 'Weerasingha', 'Weerasingha@gmail.com', 476754891, 'Badulla', 'LG'),
('SID00015', 'S00015', 'Nalinda', 'Munasingha', 'Nalinda@gmail.com', 773857335, 'Chilaw', 'HTC'),
('SID00016', 'S00016', 'Dasun ', 'Gunasekara', 'Gunasekara1@gmail.com', 413458777, 'Matara', 'Sony'),
('SID00017', 'S00017', 'Palitha', 'Gunawardana', 'palitha@gmail.com', 771248099, 'Kelaniya', 'MotorolaMoto'),
('SID00018', 'S00018', 'Oshadi', 'Mallawa Arachchi', 'oshadi.Arachchi@gmail.com', 786540008, 'Nuwaraeliya', 'Oppo'),
('SID00019', 'S00019', 'Oshani', 'Samarasingha', 'Oshani34@gmail.com', 773210006, 'Embilipitiya', 'Alcatel'),
('SID00020', 'S00020', 'Lakshani', 'Weerathungha', 'Weerathungha99@gmail.com', 782343330, 'Ratnapura', 'Micromax'),
('SID00021', 'S00021', 'Thisara', 'Weeragoda', 'Thisara@gmail.com', 721476566, 'Galle', 'Digital Storm'),
('SID00022', 'S00022', 'Saduni', 'Rajapaksha', 'Saduni.r@gmail.com', 778905555, 'Ratnapura', 'fone');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `Address` varchar(300) NOT NULL,
  `ZipCode` int(10) NOT NULL,
  `email` varchar(300) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `Address`, `ZipCode`, `email`, `password`) VALUES
(150, 'newuser', 'Colombo', 7879, 'u@u.u', ''),
(149, 'newuser', '', 0, 'u@u.u', '6cf82ee1020caef069e753c67a97a70d');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `billinginfo`
--
ALTER TABLE `billinginfo`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts`
--
ALTER TABLE `cartproducts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts2`
--
ALTER TABLE `cartproducts2`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts3`
--
ALTER TABLE `cartproducts3`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts4`
--
ALTER TABLE `cartproducts4`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts5`
--
ALTER TABLE `cartproducts5`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts6`
--
ALTER TABLE `cartproducts6`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts7`
--
ALTER TABLE `cartproducts7`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts8`
--
ALTER TABLE `cartproducts8`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts9`
--
ALTER TABLE `cartproducts9`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts10`
--
ALTER TABLE `cartproducts10`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts11`
--
ALTER TABLE `cartproducts11`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts12`
--
ALTER TABLE `cartproducts12`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts13`
--
ALTER TABLE `cartproducts13`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts14`
--
ALTER TABLE `cartproducts14`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts15`
--
ALTER TABLE `cartproducts15`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts16`
--
ALTER TABLE `cartproducts16`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts17`
--
ALTER TABLE `cartproducts17`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts18`
--
ALTER TABLE `cartproducts18`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts19`
--
ALTER TABLE `cartproducts19`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cartproducts20`
--
ALTER TABLE `cartproducts20`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CategoryID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `searchproduct`
--
ALTER TABLE `searchproduct`
  ADD PRIMARY KEY (`ProductID`);

--
-- Indexes for table `shipper`
--
ALTER TABLE `shipper`
  ADD PRIMARY KEY (`ShipperID`);

--
-- Indexes for table `shoppingcart`
--
ALTER TABLE `shoppingcart`
  ADD PRIMARY KEY (`CartID`);

--
-- Indexes for table `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`SupplierID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `billinginfo`
--
ALTER TABLE `billinginfo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT for table `cartproducts`
--
ALTER TABLE `cartproducts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `shoppingcart`
--
ALTER TABLE `shoppingcart`
  MODIFY `CartID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=151;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
