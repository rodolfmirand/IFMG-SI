.data
	trem: .space 16 
	msg_introducao: .asciiz "Quantidade de trens: " 
	msg_quantidade_vagoes: .asciiz "\n\nQuantidade de vagões do trem: "
	msg_numero_vagao: .asciiz "Número do vagão: "
	msg_printando_trem: .asciiz "Trem ordenado: "
	msg_espaco: .asciiz " " 
	
.text
	main:
		li $v0, 4
		la $a0, msg_introducao
		syscall
			
		li $v0, 5
		syscall
		move $t0, $v0
		
	iniciar_trem:
		beqz $t0, fim
		
		li $v0, 4
		la $a0, msg_quantidade_vagoes
		syscall
			
		li $v0, 5
		syscall
		move $t2, $v0
		
		la $t4, trem
		li $t1, 0
		
	acoplar_vagoes:
		bge $t1, $t2, ordenar
		
		li $v0, 4
		la $a0, msg_numero_vagao
		syscall
			
		li $v0, 5
		syscall
		move $t3, $v0
		
		sw $t3, 0($t4)
		addi $t4, $t4, 4
		addi $t1, $t1, 1
		j acoplar_vagoes
		
	ordenar:
		la $t4, trem
		li $t1, 0
		move $t7, $t2
		subi $t7, $t7, 1
		
	carregar_vagoes:	
		bge $t1, $t7, printar_vagao
		
		lw $t5, 0($t4)
		lw $t6, 4($t4)
		
		bge $t5, $t6, trocar_vagoes
		
		addi $t4, $t4, 4
		addi $t1, $t1, 1
		j carregar_vagoes
	
	trocar_vagoes:
		sw $t5, 4($t4)
		sw $t6, 0($t4)
		j ordenar
		
	printar_vagao:
		la $t4, trem
		li $t1, 0
		subi $t0, $t0, 1
		
		li $v0, 4
		la $a0, msg_printando_trem
		syscall
		
	printar_vagao_loop:
		bge $t1, $t2, iniciar_trem
		
		lw $a0, 0($t4)
		li $v0, 1
		syscall
		
		li $v0, 4
		la $a0, msg_espaco
		syscall
		
		addi $t4, $t4, 4
		addi $t1, $t1, 1
		
		j printar_vagao_loop
		
	fim: 
		li $v0, 10
		syscall
	
	
	
