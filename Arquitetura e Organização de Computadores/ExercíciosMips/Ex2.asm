.data
	notas: .word 10, 5, 1
	quantidade: .word 2, 10, 10
	
.text:
	main:
		# recebe o input
		li $v0, 5
		syscall
		move $t0, $v0
		
		# inicia variavéis
		la $t1, notas
		la $t2, quantidade
		li $t3, 0
		li $t4, 0 # contador
		
	calcular:
		# verificar contador, caso >= 3 termina o loop
		bge $t4, 3, fim
		
		lw $t5, 0($t1) # carrega valor da nota
		lw $t6, 0($t2) # carrega quantidade da nota
		
		divu $t7, $t0, $t5 # divide o input pelo valor da nota
		mflo $t8
		ble $t8, $t6, usar_todas
		move $t8, $t6
		
	usar_todas:
		mul $t9, $t8, $t5
		sub $t0, $t0, $t9
		
		add $t3, $t3, $t8
		
		addi $t1, $t1, 4
		addi $t2, $t2, 4
	
		addi $t4, $t4, 1
		j calcular
		
	fim:
		li $v0, 1
		move $a0, $t3
		syscall
		
		li $v0, 10
		syscall
