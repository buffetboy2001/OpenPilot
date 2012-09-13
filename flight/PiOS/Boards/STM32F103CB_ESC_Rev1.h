 /**
 ******************************************************************************
 *
 * @file       pios_board.h
 * @author     The OpenPilot Team, http://www.openpilot.org Copyright (C) 2010.
 * @brief      Defines board hardware for the OpenPilot Version 1.1 hardware.
 * @see        The GNU Public License (GPL) Version 3
 *
 *****************************************************************************/
/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */


#ifndef STM32103CB_CC_H_
#define STM32103CB_CC_H_

//------------------------
// Timers and Channels Used
//------------------------
/*
Timer | Channel 1 | Channel 2 | Channel 3 | Channel 4
------+-----------+-----------+-----------+----------
TIM1  |           |           |           |
TIM2  |    B-     |     B+    |     A-    |     A+
TIM3  |    C-     |     C+    |  RC In 3  |  RC In 4
TIM4  |                     DELAY
TIM16 |  PWM in   |           |           |
------+-----------+-----------+-----------+----------
*/

//------------------------
// DMA Channels Used
//------------------------
/* Channel 1  - 				*/
/* Channel 2  - 				*/
/* Channel 3  - 				*/
/* Channel 4  - 				*/
/* Channel 5  - 				*/
/* Channel 6  - 				*/
/* Channel 7  - 				*/
/* Channel 8  - 				*/
/* Channel 9  - 				*/
/* Channel 10 - 				*/
/* Channel 11 - 				*/
/* Channel 12 - 				*/


//------------------------
// BOOTLOADER_SETTINGS
//------------------------
#define BOARD_READABLE	TRUE
#define BOARD_WRITABLE	TRUE
#define MAX_DEL_RETRYS	3

//------------------------
// WATCHDOG_SETTINGS
//------------------------
#define PIOS_WATCHDOG_TIMEOUT    250
#define PIOS_WDG_REGISTER        BKP_DR4
#define PIOS_WDG_ACTUATOR        0x0001
#define PIOS_WDG_STABILIZATION   0x0002
#define PIOS_WDG_ATTITUDE        0x0004
#define PIOS_WDG_MANUAL          0x0008

//------------------------
// PIOS_LED
//------------------------
#define PIOS_LED_HEARTBEAT     1
#define PIOS_LED_ALARM         0

//-------------------------
// ADC
// PIOS_ADC_PinGet(0) = Gyro Z
// PIOS_ADC_PinGet(1) = Gyro Y
// PIOS_ADC_PinGet(2) = Gyro X
//-------------------------
//#define PIOS_ADC_OVERSAMPLING_RATE		1
#define PIOS_ADC_USE_TEMP_SENSOR		0
#define PIOS_ADC_TEMP_SENSOR_ADC		ADC1
#define PIOS_ADC_TEMP_SENSOR_ADC_CHANNEL	1

// Phase A (PA6)
#define PIOS_ADC_PIN1_GPIO_PORT			GPIOA
#define PIOS_ADC_PIN1_GPIO_PIN			GPIO_Pin_7
#define PIOS_ADC_PIN1_GPIO_CHANNEL		ADC_Channel_7
#define PIOS_ADC_PIN1_ADC			ADC1
#define PIOS_ADC_PIN1_ADC_NUMBER		1

// Phase A (PA6)
#define PIOS_ADC_PIN2_GPIO_PORT			GPIOA
#define PIOS_ADC_PIN2_GPIO_PIN			GPIO_Pin_6
#define PIOS_ADC_PIN2_GPIO_CHANNEL		ADC_Channel_6
#define PIOS_ADC_PIN2_ADC			ADC2
#define PIOS_ADC_PIN2_ADC_NUMBER		1

// Phase B (PA5)
#define PIOS_ADC_PIN3_GPIO_PORT			GPIOA
#define PIOS_ADC_PIN3_GPIO_PIN			GPIO_Pin_5
#define PIOS_ADC_PIN3_GPIO_CHANNEL		ADC_Channel_5
#define PIOS_ADC_PIN3_ADC			ADC1
#define PIOS_ADC_PIN3_ADC_NUMBER		2

// Phase C (PA4)
#define PIOS_ADC_PIN4_GPIO_PORT			GPIOA
#define PIOS_ADC_PIN4_GPIO_PIN			GPIO_Pin_4
#define PIOS_ADC_PIN4_GPIO_CHANNEL		ADC_Channel_4
#define PIOS_ADC_PIN4_ADC			ADC2
#define PIOS_ADC_PIN4_ADC_NUMBER		2

#define PIOS_ADC_NUM_PINS			4

#define PIOS_ADC_PORTS				{ PIOS_ADC_PIN1_GPIO_PORT, PIOS_ADC_PIN2_GPIO_PORT, PIOS_ADC_PIN3_GPIO_PORT, PIOS_ADC_PIN4_GPIO_PORT }
#define PIOS_ADC_PINS				{ PIOS_ADC_PIN1_GPIO_PIN, PIOS_ADC_PIN2_GPIO_PIN, PIOS_ADC_PIN3_GPIO_PIN, PIOS_ADC_PIN4_GPIO_PIN }
#define PIOS_ADC_CHANNELS			{ PIOS_ADC_PIN1_GPIO_CHANNEL, PIOS_ADC_PIN2_GPIO_CHANNEL, PIOS_ADC_PIN3_GPIO_CHANNEL, PIOS_ADC_PIN4_GPIO_CHANNEL }
#define PIOS_ADC_MAPPING			{ PIOS_ADC_PIN1_ADC, PIOS_ADC_PIN2_ADC, PIOS_ADC_PIN3_ADC, PIOS_ADC_PIN4_ADC }
#define PIOS_ADC_CHANNEL_MAPPING		{ PIOS_ADC_PIN1_ADC_NUMBER, PIOS_ADC_PIN2_ADC_NUMBER, PIOS_ADC_PIN3_ADC_NUMBER, PIOS_ADC_PIN4_ADC_NUMBER }
#define PIOS_ADC_NUM_CHANNELS			(PIOS_ADC_NUM_PINS + PIOS_ADC_USE_TEMP_SENSOR)
#define PIOS_ADC_NUM_ADC_CHANNELS		2
#define PIOS_ADC_USE_ADC2			1
#define PIOS_ADC_CLOCK_FUNCTION			RCC_APB2PeriphClockCmd(RCC_APB2Periph_ADC1 | RCC_APB2Periph_ADC2, ENABLE)
#define PIOS_ADC_ADCCLK				RCC_PCLK2_Div2
/* RCC_PCLK2_Div2: ADC clock = PCLK2/2 */
/* RCC_PCLK2_Div4: ADC clock = PCLK2/4 */
/* RCC_PCLK2_Div6: ADC clock = PCLK2/6 */
/* RCC_PCLK2_Div8: ADC clock = PCLK2/8 */
//#define PIOS_ADC_SAMPLE_TIME			ADC_SampleTime_71Cycles5
//#define PIOS_ADC_SAMPLE_TIME			ADC_SampleTime_28Cycles5
#define PIOS_ADC_SAMPLE_TIME			ADC_SampleTime_1Cycles5
/* Sample time: */
/* With an ADCCLK = 14 MHz and a sampling time of 239.5 cycles: */
/* Tconv = 13.5 + 12.5 = 26 cycles = 18�s */
/* (1 / (ADCCLK / CYCLES)) = Sample Time (�S) */

// Currently analog acquistion hard coded at 480 Hz
// PCKL2 = HCLK / 16
// ADCCLK = PCLK2 / 2
//#define PIOS_ADC_RATE		(72.0e6 / 1.0 / 8.0 / 84.0 / (PIOS_ADC_NUM_CHANNELS >> PIOS_ADC_USE_ADC2))
//#define PIOS_ADC_RATE		(72.0e6 / 1.0 / 8.0 / 41.0 / (PIOS_ADC_NUM_CHANNELS >> PIOS_ADC_USE_ADC2))
#define PIOS_ADC_RATE		(72.0e6 / 1.0 / 8.0 / 26.0 / (PIOS_ADC_NUM_CHANNELS >> PIOS_ADC_USE_ADC2))
#define PIOS_ADC_MAX_OVERSAMPLING               1


//-------------------------
// Delay Timer
//-------------------------
#define PIOS_DELAY_TIMER			TIM4
#define PIOS_DELAY_TIMER_RCC_FUNC		RCC_APB1PeriphClockCmd(RCC_APB1Periph_TIM4, ENABLE)

//-------------------------
// System Settings
//-------------------------
#define PIOS_MASTER_CLOCK			64000000
#define PIOS_PERIPHERAL_CLOCK			(PIOS_MASTER_CLOCK / 2)

//-------------------------
// Interrupt Priorities
//-------------------------
#define PIOS_IRQ_PRIO_LOW			12		// lower than RTOS
#define PIOS_IRQ_PRIO_MID			8		// higher than RTOS
#define PIOS_IRQ_PRIO_HIGH			5		// for SPI, ADC, I2C etc...
#define PIOS_IRQ_PRIO_HIGHEST			4 		// for USART etc...

//------------------------
// PIOS_I2C
// See also pios_board.c
//------------------------
#define PIOS_I2C_MAX_DEVS			1
extern uint32_t pios_i2c_main_adapter_id;
#define PIOS_I2C_MAIN_ADAPTER			(pios_i2c_main_adapter_id)

//-------------------------
// SPI
//
// See also pios_board.c
//-------------------------
#define PIOS_SPI_MAX_DEVS			0

//-------------------------
// PIOS_USART
//-------------------------
#define PIOS_USART_MAX_DEVS			1

//-------------------------
// PIOS_COM
//
// See also pios_board.c
//-------------------------
#define PIOS_COM_MAX_DEVS			2

extern uint32_t pios_com_debug_id;
#define PIOS_COM_TELEM_RF               (pios_com_debug_id)
#define PIOS_COM_DEBUG                  PIOS_COM_TELEM_RF

//-------------------------
// Receiver PWM inputs
//-------------------------
#define PIOS_PWM_NUM_INPUTS 4
#define PIOS_PWM_MAX_DEVS   2
#define PIOS_TIM_MAX_DEVS   4
#define PIOS_RCVR_MAX_DEVS  1
//-------------------------
// GPIO
//-------------------------
#define PIOS_GPIO_1_PORT			GPIOB
#define PIOS_GPIO_1_PIN				GPIO_Pin_12
#define PIOS_GPIO_1_GPIO_CLK		RCC_APB2Periph_GPIOA
#define PIOS_GPIO_2_PORT			GPIOB
#define PIOS_GPIO_2_PIN				GPIO_Pin_13
#define PIOS_GPIO_2_GPIO_CLK		RCC_APB2Periph_GPIOA

#define PIOS_GPIO_PORTS				{ PIOS_GPIO_1_PORT, PIOS_GPIO_2_PORT }
#define PIOS_GPIO_PINS				{ PIOS_GPIO_1_PIN, PIOS_GPIO_2_PIN }
#define PIOS_GPIO_CLKS				{ PIOS_GPIO_1_GPIO_CLK, PIOS_GPIO_2_GPIO_CLK }
#define PIOS_GPIO_NUM				2

//-------------------------
// USB
//-------------------------
#define PIOS_USB_ENABLED                        0
#endif /* STM32103CB_AHRS_H_ */